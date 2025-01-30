// package application5;

// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.util.HashMap;

// public class FileHandler {
// public static void storeEmployee() {
//     try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Assignment5\\employee.ser"))) {
//         oos.writeObject(Employee.employeeMap);
//     } catch (Exception e) {
//         e.printStackTrace();
//     }
// }

// public static HashMap<Integer, Employee> readEmployee() {
//     try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Assignment5\\employee.ser"))) {
//         return (HashMap<Integer, Employee>) ois.readObject();
//     } catch (FileNotFoundException e) {
//         System.out.println("File not found. Creating new file..................");
//         try {
//             new ObjectOutputStream(new FileOutputStream("Assignment5\\employee.ser")).close();
//             CEO.createCEO();
//         } catch (Exception ex) {
//             ex.printStackTrace();
//         }
//         return new HashMap<>();
//     }catch (Exception e){
//         return new HashMap<>();
//     }
// }
// }
