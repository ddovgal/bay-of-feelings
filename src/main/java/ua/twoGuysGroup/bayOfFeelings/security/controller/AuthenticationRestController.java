package ua.twoGuysGroup.bayOfFeelings.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.twoGuysGroup.bayOfFeelings.security.jwt.JwtAuthenticationRequest;
import ua.twoGuysGroup.bayOfFeelings.security.jwt.JwtAuthenticationResponse;
import ua.twoGuysGroup.bayOfFeelings.security.jwt.JwtTokenUtil;
import ua.twoGuysGroup.bayOfFeelings.security.jwt.JwtUserDetails;

@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getLogin(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final JwtUserDetails userDetails = (JwtUserDetails)
                userDetailsService.loadUserByUsername(authenticationRequest.getLogin());

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(
                userDetails.getId(),
                userDetails.getUsername(),
                jwtTokenUtil.generateToken(userDetails)
        ));
    }
}
