package application5;

import java.util.HashMap;

public class TestApp5 {
    static HashMap<Integer, Employee> storageHashMap = FileHandler.readEmployee();

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        System.out.println("Welcome!");

        try{while (true) {
            menu.displayMain();
            int choice = menu.readChoice(6);
            Employee.employeeMap=storageHashMap;

            switch (choice) {
                case 1 -> EmployeeHandler.createEmployee();
                case 2 -> EmployeeHandler.displayAll();
                case 3 -> EmployeeHandler.raiseAllSalaries();
                case 4 -> EmployeeHandler.deleteEmployee();
                case 5 -> EmployeeHandler.searchEmployee();
                case 6 -> {
                    FileHandler.storeEmployee();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }}
        catch(Exception e){
            System.out.println("Exited with erro");
        } finally {
            FileHandler.storeEmployee();
        }
    }
}
