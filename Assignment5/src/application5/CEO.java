// package application5;

// public class CEO extends Employee {
//     public static final CEO ceo = new CEO();

//     private CEO() {
//         setDesignation("CEO");
//         System.out.println("CEO created. Enter Employee details.");
//     }
    
//     public static CEO createCEO() {
//         return ceo;
//     }
   
    
// }


package application5;

import java.sql.*;

public class CEO extends Employee {
    public  static boolean ceo; 

    private CEO() {
        setDesignation("CEO");
        System.out.println("CEO created. Enter Employee details.");
    }

    public static void createCEO() {

         try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empdb", "postgres",
                "tiger");
                Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("select * from employee where eid = 1");
            if(rs.next()==true){
                ceo=true;
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        if (ceo == false ) {  
            System.out.println("CEO is not created Enter his details first...");
            ceo=true;
            CEO ceo=new CEO();
            DatabaseConnectivity.store(ceo);
        }
        
    }
}
