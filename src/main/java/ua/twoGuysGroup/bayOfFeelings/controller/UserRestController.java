package ua.twoGuysGroup.bayOfFeelings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ua.twoGuysGroup.bayOfFeelings.controller.request.ActionRequest;
import ua.twoGuysGroup.bayOfFeelings.entity.User;
import ua.twoGuysGroup.bayOfFeelings.exception.InvalidRequestParamsException;
import ua.twoGuysGroup.bayOfFeelings.exception.SelfBannedModyficationException;
import ua.twoGuysGroup.bayOfFeelings.security.jwt.JwtUserDetails;
import ua.twoGuysGroup.bayOfFeelings.service.UserService;
import ua.twoGuysGroup.bayOfFeelings.service.specification.GeneralSpecificationKeeper;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private GeneralSpecificationKeeper<User> specKeeper;


    @RequestMapping
    public Page<User> get(@RequestParam Map<String, String> requestData) throws InvalidRequestParamsException {
        List<Specification<User>> specs = new ArrayList<>();
        int page = requestData.containsKey("page") ? Integer.parseInt(requestData.remove("page")) : 0;
        Pageable pageRequest = specKeeper.createPageRequest(page, -1, specKeeper.creteSort("ratio", true));

        if (requestData.isEmpty()) return userService.getPageBySpecification(new ArrayList<>(), true, pageRequest);

        for (String key : requestData.keySet()) {
            switch (key) {
                case "sort": {
                    String field;
                    boolean asc;
                    switch (requestData.get(key)) {
                        case "hot": {
                            field = "registrationDate";
                            asc = true;
                            break;
                        }
                        case "top": {
                            field = "ratio";
                            asc = false;
                            break;
                        }
                        default:
                            throw new InvalidRequestParamsException("Sort field can be only \"hot\" or \"top\"");
                    }
                    pageRequest = specKeeper.createPageRequest(page, -1, specKeeper.creteSort(field, asc));
                    break;
                }
                case "name": {
                    specs.add(specKeeper.containingInString("login", requestData.get(key)));
                    break;
                }
                case "ratio": {
                    Integer min, max;
                    List<Integer> list = Arrays.asList(requestData.get(key).split("-")).stream()
                            .map(Integer::parseInt).collect(Collectors.toList());
                    Integer[] range = list.toArray(new Integer[list.size()]);
                    min = Math.min(range[0], range[1]);
                    max = Math.max(range[0], range[1]);
                    specs.add(specKeeper.inRange(key, min, max));
                    break;
                }
            }
        }

        return userService.getPageBySpecification(specs, true, pageRequest);
    }

    @RequestMapping("/{id}")
    public User id(@PathVariable Long id) {
        return userService.getById(id);
    }

    @RequestMapping(path = "/{id}/subscription", method = RequestMethod.POST)
    public ResponseEntity idSubscribers(@PathVariable Long id, @RequestBody ActionRequest request, Authentication auth)
            throws SelfBannedModyficationException, InvalidRequestParamsException {
        Long currentUserId = ((JwtUserDetails) auth.getPrincipal()).getId();
        if (Objects.equals(currentUserId, id))
            throw new SelfBannedModyficationException("You cannot subscribe to yourself");
        switch (request.getAction()) {
            case "add": {
                userService.subscribeTo(id, currentUserId);
                break;
            }
            case "remove": {
                userService.unsubscribeFrom(id, currentUserId);
                break;
            }
            default:
                throw new InvalidRequestParamsException("Action field can be only \"add\" or \"remove\"");
        }
        return ResponseEntity.accepted().build();
    }

    @RequestMapping(path = "/{id}/ratio", method = RequestMethod.POST)
    public ResponseEntity idRatio(@PathVariable Long id, @RequestBody ActionRequest request, Authentication auth)
            throws SelfBannedModyficationException, InvalidRequestParamsException {
        Long currentUserId = ((JwtUserDetails) auth.getPrincipal()).getId();
        if (Objects.equals(currentUserId, id))
            throw new SelfBannedModyficationException("You cannot change your own ratio");
        switch (request.getAction()) {
            case "inc": {
                userService.incrementRatio(id);
                break;
            }
            case "dec": {
                userService.decrementRatio(id);
                break;
            }
            default:
                throw new InvalidRequestParamsException("Action field can be only \"inc\" or \"dec\"");
        }
        return ResponseEntity.accepted().build();
    }

    @RequestMapping("/{id}/avatar")
    public ResponseEntity<byte[]> idAvatar(@PathVariable Long id) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(userService.getById(id).getAvatar(), headers, HttpStatus.OK);
    }

}
