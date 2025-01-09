package application;

public class Clerk extends Employee {
	
	public Clerk(String name,int age) {
		setName(name);
		setAge(age);
		setDesignation("clerk");
		setSalary(45000);
	}
	public void raiseSalary(Programmer p1,int sal) {
		p1.setSalary(sal);
		System.out.println("Clerk: " +this.getName() + " updated salary of "+p1.getName() +" to the salary of: "+p1.getSalary());
	}

}
