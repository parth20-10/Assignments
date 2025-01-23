package application5;

import java.util.List;
import java.util.Scanner;

public class EmployeeHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static void createEmployee() {
        int choice;
        do {
            System.out.println("""
                Press 1 : Programmer
                Press 2 : Clerk
                Press 3 : Manager
                Press 4 : Exit Create functionality
                """);
            choice = new MainMenu().readChoice(4);
            switch (choice) {
                case 1 -> new Programmer();
                case 2 -> new Clerk();
                case 3 -> Manager.createManager();
                case 4 -> System.out.println("Exiting create functionality.");
            }
        } while (choice != 4);
    }

    public static void displayAll() {
        if (Employee.employeeMap.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("""
                Sort employees by:
                1: ID
                2: Name
                3: Age
                4: Salary
                5: Designation
                """);
        int choice = new MainMenu().readChoice(5);
        String criteria = switch (choice) {
            case 1 -> "id";
            case 2 -> "name";
            case 3 -> "age";
            case 4 -> "salary";
            case 5 -> "designation";
            default -> throw new IllegalArgumentException("Invalid choice");
        };

        List<Employee> sortedEmployees = (List<Employee>) EmployeeUtils.sortEmployees(Employee.employeeMap, criteria);
            
        for (Employee employee : sortedEmployees) {
            employee.displayEmp();
        }
    }

    public static void raiseAllSalaries() {
        if (Employee.employeeMap.isEmpty()) {
            System.out.println("No employees to raise salary.");
        } else {
            for (Employee employee : Employee.employeeMap.values()) {
                employee.raiseSalary();
            }
            System.out.println("Salary updated for all employees.");
        }
    }

    public static void deleteEmployee() {
        System.out.print("Enter eID to delete: ");
        int deleteID = Integer.parseInt(scanner.nextLine());
        if (Employee.employeeMap.containsKey(deleteID)) {
            if (deleteID == 1) {
                System.out.println("CEO cannot be deleted.");
            } else {
                Employee.employeeMap.remove(deleteID);
                System.out.println("Employee deleted.");
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void searchEmployee() {
        System.out.println("""
                Search employee by:
                1: ID
                2: Name
                3: Designation
                """);
        int choice = new MainMenu().readChoice(3);
        String criteria = switch (choice) {
            case 1 -> "id";
            case 2 -> "name";
            case 3 -> "designation";
            default -> throw new IllegalArgumentException("Invalid choice");
        };

        System.out.print("Enter value to search: ");
        Object value = switch (criteria) {
            case "id" -> Integer.parseInt(scanner.nextLine());
            case "name", "designation" -> scanner.nextLine();
            default -> throw new IllegalArgumentException("Invalid input");
        };


        List< Employee> results = EmployeeUtils.searchEmployees(Employee.employeeMap, criteria, value);
        if (results.isEmpty()) {
            System.out.println("No employees found matching the criteria.");
        } else {
            for (Employee employee : results) {
                employee.displayEmp();
            }
        }
    }
}
