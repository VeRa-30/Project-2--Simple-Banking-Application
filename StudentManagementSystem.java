import java.util.HashMap;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Display student details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}
public class StudentManagementSystem {
    private static HashMap<String, Student> studentRecords = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Show menu options
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View Student Details");
            System.out.println("5. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    viewStudentDetails();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a new student
    private static void addStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        if (studentRecords.containsKey(studentId)) {
            System.out.println("Student ID already exists. Try again.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, age, grade);
        studentRecords.put(studentId, student);
        System.out.println("Student added successfully.");
    }

    // Method to update an existing student's information
    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        String studentId = scanner.nextLine();

        Student student = studentRecords.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Updating details for student ID: " + studentId);
        System.out.print("Enter new name (or press enter to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            student.setName(name);
        }

        System.out.print("Enter new age (or press enter to keep current): ");
        String ageInput = scanner.nextLine();
        if (!ageInput.isEmpty()) {
            student.setAge(Integer.parseInt(ageInput));
        }

        System.out.print("Enter new grade (or press enter to keep current): ");
        String grade = scanner.nextLine();
        if (!grade.isEmpty()) {
            student.setGrade(grade);
        }

        System.out.println("Student details updated.");
    }

    // Method to remove a student record
    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        String studentId = scanner.nextLine();

        if (studentRecords.containsKey(studentId)) {
            studentRecords.remove(studentId);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    // Method to view student details
    private static void viewStudentDetails() {
        System.out.print("Enter student ID to view details: ");
        String studentId = scanner.nextLine();

        Student student = studentRecords.get(studentId);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("\nStudent Details:");
            student.displayDetails();
        }
    }
}


