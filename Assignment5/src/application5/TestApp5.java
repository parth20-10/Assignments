package application5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TestApp5 {
    public static void main(String[] args) {
        MainMenue menu = new MainMenue();
        System.out.println("Welcome! ");

        while (true) {
            menu.display();
            int choice = menu.readChoice(5);
            if (choice == 1) {

                while (true) {
                    {
                        menu.displayCreate();
                        int subChoice = menu.readChoice(4);
                        switch (subChoice) {
                            case 1 -> Programmer.createProgrammer();
                            case 2 -> Clerk.creatClerk();
                            case 3 -> Manager.createManager();
                            case 4 -> {
                                System.out.println("Returning to main menu.");
                                break;
                            }
                        }
                        if (subChoice == 4) {
                            break;
                        }
                    }
                }
            } else if (choice == 2) {
                if (Employee.employeeMap.isEmpty()) {
                    System.out.println("No employees to display.");
                } else {
                    for (Object value : Employee.employeeMap.values()) {
                        ((Employee) value).displayEmp();
                    }
                }
            } else if (choice == 3) {
                if (Employee.employeeMap.isEmpty()) {
                    System.out.println("No employees to raise salary.");
                } else {
                    for (Object value : Employee.employeeMap.values()) {
                        ((Employee) value).raiseSalary();
                    }
                    System.out.println("Salary updated for all employees.");
                }
            } else if (choice == 4) {
                System.out.print("Enter eID to delete: ");
                Scanner myObj = new Scanner(System.in);
                int deleteID = myObj.nextInt();
                if (deleteID == 1) {
                    System.out.println("CEO cannot be deleted.");
                } else if (Employee.employeeMap.containsKey(deleteID)) {
                    Employee emp = Employee.employeeMap.get(deleteID);
                    emp.displayEmp();
                    System.out.println("Confirm deletion? (Y/N): ");
                    String confirm = myObj.next();
                    if (confirm.equalsIgnoreCase("Y")) {
                        Employee.employeeMap.remove(deleteID);
                        System.out.println("Employee deleted.");
                    } else {
                        System.out.println("Employee not deleted.");
                    }
                } else {
                    System.out.println("Employee not found.");
                }
            } else if (choice == 5) {
                System.out.print("Enter eID to search: ");
                Scanner myObj = new Scanner(System.in);
                int searchID = myObj.nextInt();
                if (Employee.employeeMap.containsKey(searchID)) {
                    Employee emp = Employee.employeeMap.get(searchID);
                    emp.displayEmp();
                } else {
                    System.out.println("Employee not found.");
                }
            } else if (choice == 6) {
                System.out.println("See you next time!");
                break;
            }
        }
    }
}
