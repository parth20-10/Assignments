package application5;


public final class Manager extends Employee {
    public Manager() {
        this.setDesignation("Manager");
        this.setSalary(50000);
    }
    public Manager createManager() {
        
        this.setDesignation("Manager");
        this.setSalary(50000);  
        return (Manager) this;
    }
    public void raiseSalary() {
        setSalary(getSalary() + 1500);
    }
}
