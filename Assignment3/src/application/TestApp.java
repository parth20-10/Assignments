package application;

import java.util.InputMismatchException;

import java.util.Scanner;

public class TestApp {
    public static void main(String[] args) {
        MainMenue menue = new MainMenue();
        Employee[] employeeArray = new Employee[100];
        int employeeCount = 0;
        Scanner myObj = new Scanner(System.in);

        while (true) {
            try {
                menue.display();
                int choice = myObj.nextInt();
                myObj.nextLine();

                if (choice == 1) {
                    while (true) {

                        try {
                            menue.displayCreate();
                            int subChoice = myObj.nextInt();
                            myObj.nextLine();
                            if (subChoice == 1) {
                                employeeArray[employeeCount++] = new Programmer();
                            } else if (subChoice == 2) {
                                employeeArray[employeeCount++] = new Clerk();
                            } else if (subChoice == 3) {
                                employeeArray[employeeCount++] = new Manager();
                            } else if (subChoice == 4) {
                                System.out.println("Total Employees: " + employeeCount);
                                break;
                            } else {
                                throw new UserException(null);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Only numeric input allowed");
                            myObj.nextLine();
                            continue;
                        } catch (UserException e) {
                            System.out.println("Invalid choice.");
                            // myObj.nextLine();
                            continue;
                        } catch (Exception e) {
                            System.out.println("Undefined error.");
                            // myObj.nextLine();
                            continue;
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
                    int deleteID = myObj.nextInt();
                    myObj.nextLine();

                    boolean found = false;
                    for (int i = 0; i < employeeCount; i++) {
                        if (employeeArray[i].getEID() == deleteID) {
                            System.out.println("Deleting Employee: ");
                            employeeArray[i].displayEmp();
                            found = true;
                            System.out.println("Want to delted Employee (Y/N): ");
                            String option = myObj.nextLine();
                            if (option == "Y" || option == "y") {
                                System.arraycopy(employeeArray, i + 1, employeeArray, i, employeeCount - i - 1);
                                employeeArray[--employeeCount] = null;
                            } else {
                                System.out.println("Invalid choice employee not deleted");
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
                } else {
                    throw new UserException(null);
                }
            } catch (InputMismatchException e) {
                System.out.println("Only numeric input allowed");
                myObj.nextLine();
                continue;
            } catch (UserException e) {
                System.out.println("Invalid choice.");
                // myObj.nextLine();
                continue;
            } catch (Exception e) {
                System.out.println("Undefined error.");
                // myObj.nextLine();
                continue;
            }

        }
        myObj.close();
    }

}
