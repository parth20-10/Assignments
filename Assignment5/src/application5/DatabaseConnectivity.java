package application5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class DatabaseConnectivity {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void store(Employee emp) {
        try {
            // Connection con =
            // DriverManager.getConnection("jdbc:postgresql://localhost:5432/empdb",
            // "postgres",
            // "tiger");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://empdb:5432/empdb", "postgres", "tiger");

            PreparedStatement pstmt = con.prepareStatement(
                    "insert into employee(name,age,salary,designation,department) values (?,?,?,?,?)");
            pstmt.setString(1, emp.getName());
            pstmt.setInt(2, emp.getAge());
            pstmt.setInt(3, emp.getSalary());
            pstmt.setString(4, emp.getDesignation());
            pstmt.setString(5, emp.getDepartment());

            pstmt.execute();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void display(String criteria) {
        try (Connection con = DriverManager.getConnection(
            "jdbc:postgresql://empdb:5432/empdb", "postgres", "tiger");
                Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("select * from employee order by  " + criteria);
            while (rs.next()) {
                System.out.println("Eid: " + rs.getInt(1) +
                        " Name:" + rs.getString(2) +
                        " Age: " + rs.getInt(3) +
                        " Salary: " + rs.getInt(4) +
                        " Designation: " + rs.getString(5) +
                        " Department: " + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean delete(int EID) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://empdb:5432/empdb", "postgres", "tiger");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from employee where eid = " + EID);
            stmt.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static void appraisal() {

        try {
            System.out.println("Enter the employee's Eid: ");
            int id = Integer.parseInt(reader.readLine());

            // Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://empdb:5432/empdb", "postgres", "tiger");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee where eid = " + id);
            while (rs.next()) {
                System.out.println("Eid: " + rs.getInt(1) +
                        " Name:" + rs.getString(2) +
                        " Age: " + rs.getInt(3) +
                        " Salary: " + rs.getInt(4) +
                        " Designation: " + rs.getString(5) +
                        " Department: " + rs.getString(6));
            }
            System.out.println("Enter the delta amount of apprisal: ");
            int raise = Integer.parseInt(reader.readLine());

            stmt.executeUpdate("UPDATE employee SET salary =salary +" + raise + " WHERE eid =" + id);

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void search(String criteria, String value) {
        try (Connection con = DriverManager.getConnection(
            "jdbc:postgresql://empdb:5432/empdb", "postgres", "tiger");
                Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("select * from employee where " + criteria + " = " + value);
            while (rs.next()) {
                System.out.println("Eid: " + rs.getInt(1) +
                        " Name:" + rs.getString(2) +
                        " Age: " + rs.getInt(3) +
                        " Salary: " + rs.getInt(4) +
                        " Designation: " + rs.getString(5) +
                        " Department: " + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static void search(String criteria, int value) {

        try (Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://empdb:5432/empdb", "postgres", "tiger");
                Statement stmt = con.createStatement();) {
            ResultSet rs = stmt.executeQuery("select * from employee where " + criteria + " = " + value);
            while (rs.next()) {
                System.out.println("Eid: " + rs.getInt(1) +
                        " Name:" + rs.getString(2) +
                        " Age: " + rs.getInt(3) +
                        " Salary: " + rs.getInt(4) +
                        " Designation: " + rs.getString(5) +
                        " Department: " + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

}
