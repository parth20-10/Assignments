package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenue {
    public void display() {
        System.out.println("Press 1 : Create");
        System.out.println("Press 2 : Display");
        System.out.println("Press 3 : Raise Salary");
        System.out.println("Press 4 : Delete");
        System.out.println("Press 5 : Exit");
    }

    public void displayCreate() {
        System.out.println("Press 1 : Programmer");
        System.out.println("Press 2 : Clerk");
        System.out.println("Press 3 : Manager");
        System.out.println("Press 4 : Exit Create functionality");
    }

    public int readChoice(int maxChoice) {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int choice = myObj.nextInt();
                if (choice < 1 || choice > maxChoice) {
                    throw new InvalidInputException("Invalid choice");
                }
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, it must be a number.");
                myObj.next();
            } catch (InvalidInputException e) {
                e.display(maxChoice);
            }
        }
    }
}
