import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Fees {
    int totalFees;
    int feesPaid;
    int feesPending;

    Fees(int totalFees, int feesPaid) {
        this.totalFees = totalFees;
        this.feesPaid = feesPaid;
        this.feesPending = totalFees - feesPaid;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesPending() {
        return feesPaid;
    }

    @Override
    public String toString() {
        return "Total: " + totalFees + ", Paid: " + feesPaid + ", Pending: " + feesPending + "";
    }
}

class Student {
    String name;
    int age;
    int standard;
    String school;
    String gender;
    int percentage;
    Fees fee;

    Student(String name, int age, int standard, String school, String gender, int percentage, Fees fee) {
        this.name = name;
        this.age = age;
        this.standard = standard;
        this.school = school;
        this.gender = gender;
        this.percentage = percentage;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + age + " yrs, Std " + standard + ", " + school + ", " + gender + ", " +
                "Percentage: " + percentage + "%, " + fee + ")";
    }

    public String getSchool() {
        return school;
    }

    public int getStandard() {
        return standard;
    }

    public int getPercentage() {
        return percentage;
    }

    public String getGender() {
        return gender;
    }
    public int getAge(){
        return age;
    }

    public Fees getFee() {
        return fee;
    }
}

public class StreamDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Ravi", 6, 1, "KVP", "Male", 85, new Fees(30000, 20000)),
                new Student("Sneha", 7, 2, "DSP", "Female", 90, new Fees(32000, 30000)),
                new Student("Amit", 6, 1, "SMBA", "Male", 75, new Fees(28000, 15000)),
                new Student("Priya", 8, 3, "PICT", "Female", 92, new Fees(35000, 35000)),
                new Student("Lakshmi", 7, 2, "KVP", "Female", 88, new Fees(32000, 25000)),
                new Student("Karan", 8, 3, "DSP", "Male", 76, new Fees(33000, 20000)),
                new Student("Rajesh", 9, 4, "SMBA", "Male", 81, new Fees(36000, 25000)),
                new Student("Aarav", 7, 2, "PICT", "Male", 89, new Fees(34000, 32000)),
                new Student("Meera", 8, 3, "KVP", "Female", 95, new Fees(35000, 35000)),
                new Student("Sohan", 9, 4, "DSP", "Male", 72, new Fees(37000, 25000)),
                new Student("Anjali", 6, 1, "SMBA", "Female", 84, new Fees(30000, 20000)),
                new Student("Rohit", 8, 3, "PICT", "Male", 86, new Fees(34000, 30000)),
                new Student("Gopal", 9, 4, "KVP", "Male", 80, new Fees(36000, 31000)),
                new Student("Neha", 7, 2, "DSP", "Female", 94, new Fees(32000, 32000)),
                new Student("Arjun", 9, 4, "SMBA", "Male", 78, new Fees(37000, 20000)),
                new Student("Simran", 8, 3, "PICT", "Female", 91, new Fees(34000, 34000)),
                new Student("Laksh", 6, 1, "KVP", "Male", 80, new Fees(30000, 29000)),
                new Student("Isha", 7, 2, "DSP", "Female", 96, new Fees(32000, 32000)),
                new Student("Rahul", 9, 4, "SMBA", "Male", 82, new Fees(37000, 31000)),
                new Student("Kavya", 8, 3, "PICT", "Female", 90, new Fees(34000, 34000)),
                new Student("Rani", 6, 1, "KVP", "Female", 79, new Fees(30000, 22000)),
                new Student("Pooja", 7, 2, "DSP", "Female", 87, new Fees(32000, 27000)),
                new Student("Tarun", 9, 4, "SMBA", "Male", 83, new Fees(37000, 28000)),
                new Student("Dhruv", 8, 3, "PICT", "Male", 92, new Fees(34000, 32000)),
                new Student("Ritika", 6, 1, "KVP", "Female", 36, new Fees(30000, 25000)),
                new Student("Anand", 7, 2, "DSP", "Male", 77, new Fees(32000, 22000)),
                new Student("Varun", 9, 4, "SMBA", "Male", 34, new Fees(37000, 29000)),
                new Student("Diya", 8, 3, "PICT", "Female", 28, new Fees(34000, 34000))));

        // Group students by standard and count them
        Map<Integer, Long> studentsByStandard = students.stream()
                .collect(Collectors.groupingBy(Student::getStandard, Collectors.counting()));

        System.out.println("\nStudents Count by Standard:");
        System.out.println(studentsByStandard);

        // Group students by gender and count them
        Map<String, Long> studentsByGender = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));

        System.out.println("\nStudents Count by Gender:");
        System.out.println(studentsByGender);

        // Count pass and fail students University
        Map<Boolean, Long> passStudentsCount = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getPercentage() >= 40, Collectors.counting()));

        System.out.println("\nCount of Passed and Failed Students true=>Pass false=>Fail:");
        System.out.println(passStudentsCount );

        // Count pass and fail students school-wise
        Map<String, Map<Boolean, Long>> passFailBySchool = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSchool,
                        Collectors.partitioningBy(s -> s.getPercentage() >= 40, Collectors.counting())));

        System.out.println("\nPass and Fail Count by School true=>Pass false=>Fail:");
        System.out.println(passFailBySchool
        );

        // Top 3 students in the whole university
        List<Student> top3Students = students.stream()
                .sorted(Comparator.comparingInt(Student::getPercentage).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\nTop 3 Highest-Scoring Students:");
        System.out.println(top3Students);

        // Top student per school
        Map<String, Optional<Student>> topStudentBySchool = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSchool,
                        Collectors.maxBy(Comparator.comparingInt(Student::getPercentage))));

        System.out.println("\nTop Student in Each School:");
        topStudentBySchool.forEach((school, student) -> System.out.println(school + ": " + student.orElse(null)));

        // Average age of male & female students
        Map<String, Double> avgAgeByGender = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGender,
                        Collectors.averagingInt(Student::getAge)));

        System.out.println("\nAverage Age by Gender:");
        System.out.println(avgAgeByGender);
        // Total fees collected school wise
        Map<String, Integer> totalFeesPerSchool = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSchool,
                        Collectors.summingInt(s -> s.getFee().getFeesPaid()) 
                ));

        System.out.println("\nTotal Fees Collected Per School:");
        System.out.println(totalFeesPerSchool);

        // Total fees pending school wise
        Map<String, Integer> totalFeesPaindingPerSchool = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSchool,
                        Collectors.summingInt(s -> s.getFee().getFeesPending()) 
                ));

        System.out.println("\nTotal Fees Pending Per School:");
        System.out.println(totalFeesPaindingPerSchool);

        // Total number of students in the university
        long totalStudents = students.count();
        System.out.println("\nTotal Students in the University: " + totalStudents);
    }
}
