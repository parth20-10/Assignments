 package application;

public final class Manager extends Employee {
	public Manager() {
		
		setDesignation("Manager");
		setSalary(100000);
	}
	public void raiseSalary() {
		setSalary(getSalary()+1500);
	}

}
