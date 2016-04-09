package ua.twoGuysGroup.bayOfFeelings.exception;

public class SelfBannedModyficationException extends Exception {
    public SelfBannedModyficationException() {
    }

    public SelfBannedModyficationException(String message) {
        super(message);
    }

    public SelfBannedModyficationException(String message, Throwable cause) {
        super(message, cause);
    }
}
