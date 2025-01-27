package application5;

public class Programmer extends Employee {
    private Programmer() {
        setDesignation("Programmer");
        setSalary(80000);
    }
    public static Programmer createProgrammer() {
        return new Programmer();
    }
   

    public void raiseSalary() {
        setSalary(getSalary() + 5000);
    }
}
