package application5;

public final class Clerk extends Employee {
    public Clerk() {
        this.setDesignation("Clerk");
        this.setSalary(20000);
    }

    public Clerk creatClerk() {
        
        
        return (Clerk) this;
    }

    public void raiseSalary() {
        setSalary(getSalary() + 2000);
    }
}
