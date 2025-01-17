package application5;

public final class Programmer extends Employee {
    public Programmer() {
        this.setDesignation("Programmer");
        this.setSalary(80000);
    }
    public Programmer createProgrammer() {
        this.setDesignation("Programmer");
        this.setSalary(80000);
        
        return (Programmer) this;
    }

    public void raiseSalary() {
        setSalary(getSalary() + 5000);
    }
}
