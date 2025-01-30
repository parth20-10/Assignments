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
                case 1 -> DatabaseConnectivity.store(Programmer.createProgrammer());
                case 2 -> DatabaseConnectivity.store(Clerk.createClerk());
                case 3 -> DatabaseConnectivity.store(Manager.createManager());
                case 4 -> System.out.println("Exiting create functionality.");
            }
        } while (choice != 4);
    }

    public static void displayAll() {
        // if (Employee.employeeMap.isEmpty()) {
        // System.out.println("No employees to display.");
        // return;
        // }

        System.out.println("""
                Sort employees by:
                1: ID
                2: Name
                3: Age
                4: Salary
                5: Designation
                """);
        int choice = new MainMenu().readChoice(5);
        switch (choice) {
            case 1 -> DatabaseConnectivity.display("eid");
            case 2 -> DatabaseConnectivity.display("name");
            case 3 -> DatabaseConnectivity.display("age");
            case 4 -> DatabaseConnectivity.display("salary");
            case 5 -> DatabaseConnectivity.display("designation");
            default -> throw new IllegalArgumentException("Invalid choice");
        }
        ;
        // List<Employee> sortedEmployees = (List<Employee>)
        // EmployeeUtils.sortEmployees(Employee.employeeMap, criteria);

        // for (Employee employee : sortedEmployees) {
        // employee.displayEmp();
        // }
    }

    public static void deleteEmployee() {
        System.out.print("Enter eID to delete: ");
        int deleteID = Integer.parseInt(scanner.nextLine());
        if (deleteID == 1) {
            System.out.println("CEO can tbe deleted");
            return;
        }
        if (DatabaseConnectivity.delete(deleteID)) {

            System.out.println("Employee deleted.");

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
        // String criteria=switch (choice) {
        // case 1 -> ;
        // case 2 -> ;
        // case 3 -> ;
        // default -> throw new IllegalArgumentException("Invalid choice");
        // };

        System.out.print("Enter value to search: ");
        Object value = switch (choice) {
            case 1 -> Integer.parseInt(scanner.nextLine());
            case 2, 3 -> scanner.nextLine();
            default -> throw new IllegalArgumentException("Invalid input");
        };
        switch (choice) {
            case 1 -> DatabaseConnectivity.search("eid", (Integer) value);
            case 2 -> DatabaseConnectivity.search("name", (String) value);
            case 3 -> DatabaseConnectivity.search("designation", (String) value);
            default -> throw new IllegalArgumentException("Invalid choice");
        }

        // List< Employee> results = EmployeeUtils.searchEmployees(Employee.employeeMap,
        // criteria, value);
        // if (results.isEmpty()) {
        // System.out.println("No employees found matching the criteria.");
        // } else {
        // for (Employee employee : results) {
        // employee.displayEmp();
        // }
        // }
    }
}
