package application;

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
        System.out.print("Enter Age: ");
        this.age = myObj.nextInt();
        myObj.nextLine();
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
}
