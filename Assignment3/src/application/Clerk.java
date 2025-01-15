package application;

public final class Clerk extends Employee {
    public Clerk() {
        setDesignation("Clerk");
        setSalary(20000);
    }

    public void raiseSalary() {
        setSalary(getSalary() + 2000);
    }
}
