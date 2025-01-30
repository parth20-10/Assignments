package application5;

import java.util.HashMap;

public abstract class Employee implements java.io.Serializable {
    // public static HashMap<Integer, Employee> employeeMap = new HashMap<>();
    private int eID;
    private String name;
    private int age;
    private int salary;
    private String designation;
    private String department;

    public Employee() {

        try  {
            
            if(CEO.ceo==false ) {
                
                CEO.createCEO();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        name = GetDetails.setName("");
        age = GetDetails.setAge(0, 21, 60);
        department =GetDetails.setDepartment();
        salary =GetDetails.setSalary();
        // Employee.employeeMap.put(eID, this);

    }

    // public void displayEmp() {
    //     System.out.println("eID: " + eID + ", Name: " + name + ", Age: " + age +
    //             ", Designation: " + designation + ", Salary: " + salary);
    // }

    public  void raiseSalary(){
        DatabaseConnectivity.appraisal();
    };

    

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
    public String getDepartment(){
        return department;
    }
}
