package application;

public final class Programmer extends Employee {
    public Programmer() {
        setDesignation("Programmer");
        setSalary(30000);
    }

    public void raiseSalary() {
        setSalary(getSalary() + 5000);
    }
}
