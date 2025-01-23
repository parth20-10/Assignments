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
        if (CEO.ceo == null) {
            System.out.println("CEO not created. Creating CEO Enter His details.");
            CEO.createCEO();
        }
        eID = GetDetails.setId();
        name = GetDetails.setName("");
        age = GetDetails.setAge(0, 21, 60);
        employeeMap.put(eID, this);
        GetDetails.storeEmployee(null);
    }

    public void displayEmp() {
        System.out.println("eID: " + eID + ", Name: " + name + ", Age: " + age +
                ", Designation: " + designation + ", Salary: " + salary);
    }

    public abstract void raiseSalary();

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public int geteID() {
        return eID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
