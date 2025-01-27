package application5;

public class Clerk extends Employee {
    private Clerk() {
        setDesignation("Clerk");
        setSalary(20000);
    }

    public static Clerk createClerk() {
        return new Clerk();
    }
    
    public void raiseSalary() {
        setSalary(getSalary() + 2000);
    }
}
