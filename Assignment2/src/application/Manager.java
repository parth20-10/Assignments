 package application;

public class Manager extends Employee {
	public Manager(String name,int age) {
		setName(name);
		setAge(age);
		setDesignation("Manager");
		setSalary(100000);
	}
	public void raiseSalary() {
		setSalary(getSalary()+1500);
	}

}
