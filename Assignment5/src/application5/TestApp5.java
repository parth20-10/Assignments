package application5;

import java.util.Scanner;

public class TestApp5 {
    public static void main(String[] args) {
        MainMenue menue = new MainMenue();
        Employee[] employeeArray = new Employee[100];
        int employeeCount = 0;
        System.out.println("Welcome Enter the CEO Details: ");
        employeeArray[employeeCount++] = CEO.createCEO();
        while (true) {

            menue.display();
            int choice = menue.readChoice(5);
            if (choice == 1) {
                while (true) {

                    menue.displayCreate();
                    int subChoice = menue.readChoice(4);
                    if (subChoice == 1) {
                        employeeArray[employeeCount++] = new Programmer();
                    } else if (subChoice == 2) {
                        employeeArray[employeeCount++] = new Clerk();
                    } else if (subChoice == 3) {
                        employeeArray[employeeCount++] = new Manager();
                    } else if (subChoice == 4) {
                        System.out.println("Total Employees: " + employeeCount);
                        break;
                    }

                }
            } else if (choice == 2) {
                if (employeeCount == 0) {
                    System.out.println("No employees to display.");
                } else {
                    for (int i = 0; i < employeeCount; i++) {
                        employeeArray[i].displayEmp();
                    }
                }
            } else if (choice == 3) {
                if (employeeCount == 0) {
                    System.out.println("No employees to raise salary.");
                } else {
                    for (int i = 0; i < employeeCount; i++) {
                        employeeArray[i].raiseSalary();
                    }
                    System.out.println("Salary updated for all employees.");
                }
            } else if (choice == 4) {
                if (employeeCount == 0) {
                    System.out.println("No employees to delete.");
                    continue;
                }

                System.out.print("Enter eID to delete: ");
                Scanner myObj = new Scanner(System.in);

                int deleteID = myObj.nextInt();
                myObj.nextLine();

                boolean found = false;
                if(deleteID == 1){
                    System.out.println("CEO cannot be deleted.");
                    continue;
                }
                for (int i = 0; i < employeeCount; i++) {
                    if (employeeArray[i].getEID() == deleteID) {
                        System.out.println("Deleting Employee: ");
                        employeeArray[i].displayEmp();
                        found = true;
                        System.out.println("Want to delted Employee (Y/N): ");
                        String option = myObj.nextLine();
                        if (option.strip().equalsIgnoreCase("Y")) {
                            System.arraycopy(employeeArray, i + 1, employeeArray, i, employeeCount - i - 1);
                            employeeArray[--employeeCount] = null;
                        } else {
                            System.out.println("Employee not deleted");
                        }

                        break;
                    }
                }
                if (!found) {
                    System.out.println("Employee not found.");
                }

            } else if (choice == 5) {
                System.out.println("See you next time!");
                break;
            }

        }
    }

}
