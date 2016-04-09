package ua.twoGuysGroup.bayOfFeelings.exception;

public class InvalidRequestParamsException extends Exception {
    public InvalidRequestParamsException() {
    }

    public InvalidRequestParamsException(String message) {
        super(message);
    }

    public InvalidRequestParamsException(String message, Throwable cause) {
        super(message, cause);
    }
}
