package application5;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetDetails {
    public static int setAge(int minAge, int maxAge) {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter Age: ");
                int age = myObj.nextInt();
                if (age < minAge || age > maxAge) {
                    throw new InvalidDataException("Age must be between " + minAge + " and " + maxAge);
                }
                return age;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, must be a number.");
                myObj.next();
            } catch (InvalidDataException e) {
                e.display();
            }
        }
    }

    public static String setName() {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter Name: ");
                String name = myObj.nextLine();
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

    public static int setId() {
        Scanner myObj = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter ID: ");
                int id = myObj.nextInt();
                if (id <= 0 || Employee.employeeMap.containsKey(id))  {
                    throw new InvalidDataException("ID must be a positive number and unique.");
                }
                return id;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, must be a number.");
                myObj.next();
            } catch (InvalidDataException e) {
                e.display();
            }
            catch (Exception e) {
                System.out.println("Invalid input, must be a number.");
                myObj.next();
            }
        }
    }
}
