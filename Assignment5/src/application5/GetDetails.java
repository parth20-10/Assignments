package application5;



import java.util.InputMismatchException;
import java.util.RandomAccess;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

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

    public static void storeEmployee(Employee employee) {
        try{
            RandomAccessFile employeeFile = new RandomAccessFile("employee.csv","rw");
            employeeFile.seek(employeeFile.length());
            employeeFile.writeBytes(employee.geteID() + "," + employee.getName() + "," + employee.getAge() + "," + employee.getDesignation() + "," + employee.getSalary() + "\n");
            employeeFile.close();}
            catch (FileNotFoundException e) {
                try {
                    FileOutputStream file = new FileOutputStream("employee.csv");
                    file.close();
                    storeEmployee(employee);
                } catch (Exception ex) {
                    System.out.println("Error in creating employee file.");
                }
            }
            catch (Exception e) {
                System.out.println("Error in storing employee details.");
            }
    }
}
    