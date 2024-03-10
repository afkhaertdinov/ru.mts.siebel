package HomeWork.Service;

public class InvalidAnimalException extends RuntimeException{
    public InvalidAnimalException(String message) {
        super(message);
    }
    public InvalidAnimalException(String message, Throwable cause) {
        super(message, cause);
    }
}
