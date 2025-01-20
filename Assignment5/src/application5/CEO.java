package application5;
public class CEO extends Employee {
    public static final CEO ceo = new CEO();
    private CEO() {
        if(ceo == null){
            
        }
        setDesignation("CEO");
        setSalary(1000000);
    }
    public static CEO createCEO() {
        return ceo;
    }

    public void raiseSalary() {
       
    }
}
