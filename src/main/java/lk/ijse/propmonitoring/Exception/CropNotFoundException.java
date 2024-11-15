package lk.ijse.propmonitoring.Exception;

public class CropNotFoundException extends RuntimeException {
    public CropNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CropNotFoundException() {
        super();
    }

    public CropNotFoundException(String message) {
        super(message);
    }
}
