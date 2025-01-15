package application;

public abstract class Employee {
    private static int nextEID = 1;
    private String name;
    private int eID;
    private int age;
    private int salary;
    private String designation;

    public Employee() {
        this.eID = nextEID++;
        this.age = GetDetails.setAge(0, 21, 60);
        this.name = GetDetails.setName("");
    }

    public void displayEmp() {
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
