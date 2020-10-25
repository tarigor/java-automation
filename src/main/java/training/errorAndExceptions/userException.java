package training.errorAndExceptions;

public class userException extends Exception {
    public userException() {
    }

    public userException(String message) {
        super(message);
    }

    public userException(String message, Throwable cause) {
        super(message, cause);
    }

    public userException(Throwable cause) {
        super(cause);
    }
}
