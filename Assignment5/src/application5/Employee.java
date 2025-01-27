package application5;

import java.io.RandomAccessFile;
import java.util.HashMap;

public abstract class Employee implements java.io.Serializable {
    public static HashMap<Integer, Employee> employeeMap = new HashMap<>();
    private int eID;
    private String name;
    private int age;
    private int salary;
    private String designation;

    public Employee() {

        try (RandomAccessFile raf = new RandomAccessFile("Assignment5\\employee.ser", "r")) {
            long length = raf.length();
            
            if(CEO.ceo==null ) {
                
                System.out.println("CEO is not created Enter his details first...");
                CEO.createCEO();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        eID = GetDetails.setId();
        name = GetDetails.setName("");
        age = GetDetails.setAge(0, 21, 60);
        Employee.employeeMap.put(eID, this);

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
