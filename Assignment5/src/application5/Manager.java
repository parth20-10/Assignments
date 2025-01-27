package application5;

public class Manager extends Employee {
    // private static final int MAX_MANAGERS = 5;
    // private static int managerCount = 0;

    private Manager() {
        // managerCount++;
        setDesignation("Manager");
        setSalary(50000);
    }
    
    // public static Manager createManager() {
    //     if (managerCount < MAX_MANAGERS) {
    //         return new Manager();
    //     } else {
    //         System.out.println("Manager limit reached");
    //         return null;
    //     }
    // }
    public static Manager createManager() {
        
        return new Manager();
    }
    

    public void raiseSalary() {
        setSalary(getSalary() + 1500);
    }
}
