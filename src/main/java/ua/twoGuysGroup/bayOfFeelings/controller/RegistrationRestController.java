package ua.twoGuysGroup.bayOfFeelings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ua.twoGuysGroup.bayOfFeelings.entity.User;
import ua.twoGuysGroup.bayOfFeelings.exception.RegistrationException;
import ua.twoGuysGroup.bayOfFeelings.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/register", method = RequestMethod.POST)
public class RegistrationRestController {

    @Value("${user.register.location-path}")
    private String USERS_PATH;

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping
    public ResponseEntity registerUser(
            HttpServletRequest request,
            String login,
            String password,
            String email,
            @RequestParam(required = false) MultipartFile avatar
    ) throws Exception {
        if (isInUse(login)) throw new RegistrationException("Such login is already in use");
        User newUser = new User();
        newUser.setLogin(login);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        if (avatar != null) newUser.setAvatar(avatar.getBytes());

        HttpHeaders headers = new HttpHeaders();
        String subRoute = request.getRequestURI();
        String fullRoute = request.getRequestURL().toString();
        headers.setLocation(new URI(fullRoute.replace(subRoute, "/") + USERS_PATH + userService.save(newUser).getId()));
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping("/check")
    public Map<String, Object> validateLogin(String login) {
        Map<String, Object> responseData = new HashMap<>(2);
        responseData.put("requestLogin", login);
        responseData.put("isInUse", isInUse(login));
        return responseData;
    }

    private boolean isInUse(String login) {
        return userService.getByLogin(login) != null;
    }

}
