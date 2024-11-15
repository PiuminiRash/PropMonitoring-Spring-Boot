package lk.ijse.propmonitoring.Exception;

public class FieldNotFoundException extends RuntimeException {
    public FieldNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FieldNotFoundException() {
        super();
    }

    public FieldNotFoundException(String message) {
        super(message);
    }
}
