// class A {
//     private static A instance = null;

//     protected A() {
//         try {
//             if (instance != null && this instanceof A) {
//                 return;
//             } else {
//                 instance = this;
//             }
//         } catch (RuntimeException e) {
//             System.out.println(e.getMessage());
//         }

//     }

//     public static A getObject() {
//         try {
//             if (instance == null) {
//                 instance = new A();
//             } else {
//                 throw new RuntimeException("Instance already created! Use A.getObject() method.");
//             }
//         } catch (RuntimeException e) {
//             System.out.println(e.getMessage());
//         }
//         return instance;
//     }
// }

// class B extends A {
//     private static B instance = null;

//     private B() {

//     }

//     public static B getObject() {
//         try {
//             if (instance == null) {
//                 instance = new B();
//             } else {
//                 throw new RuntimeException("Instance already created! Use B.getObject() method.");
//             }
//         } catch (RuntimeException e) {
//             System.out.println(e.getMessage());
//         }
//         return instance;
//     }
// }

// public class SingletonAssignment {
//     public static void main(String args[]) {
//         System.out.println("Creating object A");
//         A a1 = new A();
//         System.out.println(a1);
//         System.out.println("Creating object B1");
//         B b1 = B.getObject();
//         System.out.println(b1);

//         System.out.println("Creating object A2");
//         A a2 = A.getObject();
//         System.out.println(a2);
//         System.out.println("Creating object B2");
//         B b2 = B.getObject();
//         System.out.println(b2);
//         System.out.println("Creating object A3");
//         A a3 = A.getObject();
//         System.out.println(a3);
//         System.out.println("the object A1 and A2 are same: " + (a1.equals(a3)));

//         A a4 = new A();
//         System.out.println(a4);

//     }
// }


class InstanceAlreadyExistException extends RuntimeException {
    public InstanceAlreadyExistException() {}
    public InstanceAlreadyExistException(String msg) {
        super(msg);
    }
}

class A {
    private static A a1 = null;

     A() {
        if (this instanceof B) {
            System.out.println("B instance created...");
        } else if (a1 == null) {
            a1 = this;
            System.out.println("A instance created...");
        } else {
            throw new InstanceAlreadyExistException();
        }
    }

    public static A getObject() {
        if (a1 == null)
            a1 = new A();
        return a1;
    }
}

class B extends A {
    private static final B b1 = new B();

    private B() {}

    public static B getObject() {
        return b1;
    }
}

public class SingletonAssignment {
    public static void main(String args[]) {
        B b1 = B.getObject();
        A a1 = A.getObject();
        System.out.println(a1);
        System.out.println(b1);

        A a2 = A.getObject();
        B b2 = B.getObject();
        System.out.println(a2);
        System.out.println(b2);

        A a5 = new A();
        System.out.println(a5);
    }
}
