package ua.twoGuysGroup.bayOfFeelings.exception;

public class RegistrationException extends Exception {
    public RegistrationException() {
    }

    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
