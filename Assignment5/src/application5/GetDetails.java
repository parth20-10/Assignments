package application5;




import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;


public class GetDetails {
    public static int setAge(int age, int minAge, int maxAge) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter Age: ");
                age = Integer.parseInt(reader.readLine());
                if (!(minAge <= age && age <= maxAge)) {
                    throw new InvalidDataException("Age must be between " + minAge + " and " + maxAge);
                }
                return age;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, it must be a number.");
            } catch (InvalidDataException e) {
                e.display();
            } catch (IOException e) {
                System.out.println("An error occurred while reading input.");
            }
        }
    }

    public static String setName(String name) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter Name: ");
                name = reader.readLine();
                Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]+\\s[A-Z][a-zA-Z]+$");
                Matcher matcher = pattern.matcher(name);
                if (!matcher.matches()) {
                    throw new InvalidDataException("Name must be in the format: FirstName LastName");
                }
                return name;
            } catch (InvalidDataException e) {
                e.display();
            } catch (IOException e) {
                System.out.println("An error occurred while reading input.");
            }
        }
    }

    public static int setId() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Enter ID: ");
                int id = Integer.parseInt(reader.readLine());
                if (id <= 0 || Employee.employeeMap.containsKey(id)) {
                    throw new InvalidDataException("ID must be a positive number and unique.");
                }
                return id;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, must be a number.");
            } catch (InvalidDataException e) {
                e.display();
            } catch (IOException e) {
                System.out.println("An error occurred while reading input.");
            }
        }
    }
}
    