package application5;

public  class Programmer extends Employee {
    public Programmer() {
        this.setDesignation("Programmer");
        this.setSalary(80000);
    }
    public static Programmer createProgrammer() {
        return new Programmer();
    }

    public void raiseSalary() {
        setSalary(getSalary() + 5000);
    }
}
