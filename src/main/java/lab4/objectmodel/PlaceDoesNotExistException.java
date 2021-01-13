package lab4.objectmodel;

public class PlaceDoesNotExistException extends Exception {
    private String message;

    PlaceDoesNotExistException(String message) {
        super(message);
    }
}
