// package application5;

// import java.util.*;

// public class EmployeeUtils {

//     public static <T extends Employee> List<T> sortEmployees(Map<Integer, T> employeeMap, String criteria) {
//         List<T> employeeList = new ArrayList<>(employeeMap.values());
//         Comparator<T> comparator = getComparator(criteria);
//         Collections.sort(employeeList, comparator);
//         return employeeList;
//     }

//     private static <T extends Employee> Comparator<T> getComparator(String criteria) {
//         return switch (criteria.toLowerCase()) {
//             case "id" -> Comparator.comparing(Employee::geteID);
//             case "name" -> Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER);
//             case "age" -> Comparator.comparing(Employee::getAge);
//             case "salary" -> Comparator.comparing(Employee::getSalary);
//             case "designation" -> Comparator.comparing(Employee::getDesignation, String.CASE_INSENSITIVE_ORDER);
//             default -> throw new IllegalArgumentException("Invalid sorting criteria: " + criteria);
//         };
//     }

//     public static <T extends Employee> List<T> searchEmployees(Map<Integer, T> employeeMap, String criteria, Object value) {
//         List<T> results = new ArrayList<>();
//         for (T employee : employeeMap.values()) {
//             if (matchesCriteria(employee, criteria, value)) {
//                 results.add(employee);
//             }
//         }
//         return results;
//     }

//     private static boolean matchesCriteria(Employee employee, String criteria, Object value) {
//         return switch (criteria.toLowerCase()) {
//             case "id" -> employee.geteID() == (int) value;
//             case "name" -> employee.getName().equalsIgnoreCase((String) value);
//             case "designation" -> employee.getDesignation().equalsIgnoreCase((String) value);
//             default -> throw new IllegalArgumentException("Invalid search criteria: " + criteria);
//         };
//     }
// }
