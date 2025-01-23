package application5;

public class TestApp5 {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        System.out.println("Welcome!");

        while (true) {
            menu.displayMain();
            int choice = menu.readChoice(6);

            switch (choice) {
                case 1 -> EmployeeHandler.createEmployee();
                case 2 -> EmployeeHandler.displayAll();
                case 3 -> EmployeeHandler.raiseAllSalaries();
                case 4 -> EmployeeHandler.deleteEmployee();
                case 5 -> EmployeeHandler.searchEmployee();
                case 6 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
