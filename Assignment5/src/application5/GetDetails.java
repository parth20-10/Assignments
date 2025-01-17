package application5;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetDetails {
    public static int setAge(int age, int minAge, int maxAge) {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter Age: ");
                age = myObj.nextInt();
                if (!(minAge <= age && age <= maxAge)) {
                    throw new InvalidDataException("Age must be between " + minAge + " and " + maxAge);
                }
                return age;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, it must be a number.");
                myObj.next();
            } catch (InvalidDataException e) {
                e.display();
            }
        }
    }

    public static String setName(String name) {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter Name: ");
                name = myObj.nextLine();
                Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]+\\s[A-Z][a-zA-Z]+$");
                Matcher matcher = pattern.matcher(name);
                if (!matcher.matches()) {
                    throw new InvalidDataException("Name must be in the format: FirstName LastName");
                }
                return name;
            } catch (InvalidDataException e) {
                e.display();
            }
        }
    }
}
