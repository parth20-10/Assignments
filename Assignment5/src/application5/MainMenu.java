package application5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    public void displayMain() {
        System.out.println("1: Create");
        System.out.println("2: Display");
        System.out.println("3: Raise Salary");
        System.out.println("4: Delete");
        System.out.println("5: Search");
        System.out.println("6: Exit");
    }

    
    public int readChoice(int maxChoice) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder buffer = new StringBuilder();
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                buffer.append(reader.readLine());
                int choice = Integer.parseInt(buffer.toString().trim());
                if (choice < 1 || choice > maxChoice) {
                    throw new InvalidInputException("Invalid choice");
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, it must be a number.");
                buffer.setLength(0); 
            } catch (InvalidInputException e) {
                e.display(maxChoice);
                buffer.setLength(0); 
            } catch (IOException e) {
                System.out.println("An error occurred while reading input.");
                buffer.setLength(0); 
            }
        }
    }
}
