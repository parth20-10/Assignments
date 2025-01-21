import java.lang.reflect.Method;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("Calculator");
            Object obj = c.getDeclaredConstructor().newInstance();

            Method[] methods = c.getDeclaredMethods();
            System.out.println("Available operations:");
            for (Method method : methods) {
                System.out.println("- " + method.getName());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the operation: ");
            String operation = scanner.next();

            Method methodToInvoke = c.getMethod(operation, int.class, int.class);

            System.out.print("Enter the first number: ");
            int param1 = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int param2 = scanner.nextInt();

            Object result = methodToInvoke.invoke(obj, param1, param2);

            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }
}
