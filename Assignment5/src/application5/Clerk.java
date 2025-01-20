package application5;

public class Clerk extends Employee {
    public Clerk() {
        this.setDesignation("Clerk");
        this.setSalary(20000);
    }

    public static Clerk creatClerk() {

        return new Clerk();
    }

    public void raiseSalary() {
        setSalary(getSalary() + 2000);
    }
}
