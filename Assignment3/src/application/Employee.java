package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Employee {
    private static int nextEID = 1;
    private String name;
    private int eID;
    private int age;
    private int salary;
    private String designation;

    public Employee() {
        this.eID = nextEID++;
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter Name: ");
        this.name = myObj.nextLine();
        setAge(myObj);

    }

    final public void displayEmp() {
        System.out.println("eID: " + eID + ", Name: " + name + ", Age: " + age +
                ", Designation: " + designation + ", Salary: " + salary);
    }

    public abstract void raiseSalary();

    public int getEID() {
        return eID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    private void setAge(Scanner myObj) {
        try {
            System.out.print("Enter Age: ");
            this.age = myObj.nextInt();
            myObj.nextLine();
            if(!(21 <= age && age <= 60)) {
                throw new UserException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input it must be number  " );
            setAge( myObj);
        } catch (UserException e) {
            System.out.println("Age must be between 21 and 60");
            setAge(myObj);
        }
    }
}
