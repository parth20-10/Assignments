package application5;

public class Programmer extends Employee {
    private Programmer() {
        setDesignation("Programmer");
    }
    public static Programmer createProgrammer() {
        return new Programmer();
    }
   

    
}
