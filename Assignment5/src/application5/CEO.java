package application5;

public class CEO extends Employee {
    public static final CEO ceo = new CEO();

    private CEO() {
        setDesignation("CEO");
        setSalary(1000000);
        System.out.println("CEO created. Enter Employee details.");
    }

    public static CEO createCEO() {
        return ceo;
    }

    public void raiseSalary() {}
}
