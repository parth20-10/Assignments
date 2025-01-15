package application;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }

    public void display(int maxChoice) {
        System.out.println("Choice must be between 1 and " + maxChoice);
    }
}
