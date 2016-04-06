package ua.twoGuysGroup.bayOfFeelings.security.jwt;

public class JwtAuthenticationResponse {

    private final Long userId;
    private final String userLogin;
    private final String token;

    public JwtAuthenticationResponse(Long userId, String userLogin, String token) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getToken() {
        return token;
    }
}
