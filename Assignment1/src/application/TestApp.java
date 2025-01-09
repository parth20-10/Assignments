package application;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager M1 =new Manager("Ravi",32);
		Programmer P1=new Programmer("Raj",24);
		Clerk C1=new Clerk("Kavya",26);
		
		C1.raiseSalary(P1, 52000);

	}

}
