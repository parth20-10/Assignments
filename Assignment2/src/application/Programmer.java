package application;

public class Programmer extends Employee{
	
	public Programmer(String name,int age) {
		setName(name);
		setAge(age);
		setDesignation("Programmer");
		setSalary(30000);
	}
	
	public void raiseSalary() {
		setSalary(getSalary()+5000);
	}
}
