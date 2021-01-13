package lab4.objectmodel;

public class UnableToLandException extends RuntimeException{
    private String s;

    UnableToLandException(String s){
        this.s = s;
    }
}
