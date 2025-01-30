package application5;

public class Clerk extends Employee {
    private Clerk() {
        setDesignation("Clerk");
    }

    public static Clerk createClerk() {
        return new Clerk();
    }
    
    
}
