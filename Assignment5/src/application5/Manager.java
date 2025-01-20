package application5;

public class Manager extends Employee {
    private static int managerCount = 0;

    private Manager() {
        managerCount++;
        this.setDesignation("Manager");
        this.setSalary(50000);
    }

    public static Manager createManager() {

        try {
            if (Manager.managerCount < 5) {
                Manager manager = new Manager();
                return manager;

            } else {
                throw new Exception("Manager limit reached");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void raiseSalary() {
        setSalary(getSalary() + 1500);
    }
}
