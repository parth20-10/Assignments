package application5;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
    public void display() {
        System.out.println(super.getMessage());
    }
}
