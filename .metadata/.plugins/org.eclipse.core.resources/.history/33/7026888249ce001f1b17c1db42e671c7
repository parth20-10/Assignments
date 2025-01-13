package application;
import java.util.ArrayList;
import java.util.Scanner;

public class TestApp {

    public static void main(String[] args) {
        System.out.println("----WELCOME TO WISSEN----");
        MainMenue menue = new MainMenue();
        menue.display();

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter your Choice: ");
        int choice = myObj.nextInt();
        myObj.nextLine(); 
        ArrayList<Employee> employeeArray = new ArrayList<>();

        while (choice != 4) {
            if (choice == 1) {
                menue.displayCreate();
                System.out.print("Enter your Employee Choice: ");
                int subChoice = myObj.nextInt();
                myObj.nextLine(); 
                int count = 0;

                while (subChoice != 4) {
                    if (subChoice == 1) {
                        System.out.print("Enter Programmer Name: ");
                        String name = myObj.nextLine();
                        System.out.print("Enter Programmer Age: ");
                        int age = myObj.nextInt();
                        employeeArray.add(new Programmer(name, age));
                        count++;
                    }
                    else if (subChoice == 2) {
                        System.out.print("Enter Clerk Name: ");
                        String name = myObj.nextLine();
                        System.out.print("Enter Clerk Age: ");
                        int age = myObj.nextInt();
                        employeeArray.add(new Clerk(name, age));
                        count++;
                    }
                    else if (subChoice == 3) {
                        System.out.print("Enter Manager Name: ");
                        String name = myObj.nextLine();
                        System.out.print("Enter Manager Age: ");
                        int age = myObj.nextInt();
                        employeeArray.add(new Manager(name, age));
                        count++;
                    }
                    
                    
                    else {
                        System.out.println("Enter valid Choice");
                    }

                    menue.displayCreate();
                    System.out.print("Enter your Employee Choice: ");
                    subChoice = myObj.nextInt();
                    myObj.nextLine(); 
                }
                System.out.println("New Employees Created: " + count);

            }
            else if (choice == 2) {
                menue.displayInformation(employeeArray);
            }
            else if (choice == 3) {
                menue.raiseSalaryMenu(employeeArray);
            }
            
            else {
                System.out.println("Enter valid Choice");
            }

            menue.display();
            System.out.print("Enter your Choice: ");
            choice = myObj.nextInt();
            myObj.nextLine(); 
        }
       
        System.out.println("See you next time");
        myObj.close();

    }
}
