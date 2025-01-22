package application5;

import java.util.HashMap;

public abstract class Employee {
    public static HashMap<Integer, Employee> employeeMap = new HashMap<>();
    private int eID;
    private String name;
    private int age;
    private int salary;
    private String designation;

    public Employee() {
        if(CEO.ceo == null){
            System.out.println("CEO Details not found. Please create CEO first.");
            CEO.createCEO();
        }
        this.eID = GetDetails.setId();
        this.name = GetDetails.setName();
        this.age = GetDetails.setAge(18, 60);
        employeeMap.put(eID, this);
        
    }

    public void displayEmp() {
        System.out.println("eID: " + eID + ", Name: " + name + ", Age: " + age +
                ", Designation: " + designation + ", Salary: " + salary);
    }

    public abstract void raiseSalary();

    public int getEID() {
        return eID;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
