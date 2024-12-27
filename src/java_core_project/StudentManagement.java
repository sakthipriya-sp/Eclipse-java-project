package java_core_project;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private String course;

    
    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Course: " + course;
    }
}

public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    int id;
    String name,course;
    public void addStudent() {
        System.out.print("Enter Student ID: ");
        id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Student Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        course = scanner.nextLine();

        Student student = new Student(id, name, course);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

   
    public void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter New Name: ");
                student.setName(scanner.nextLine());

                System.out.print("Enter New Course: ");
                student.setCourse(scanner.nextLine());

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

   
    public void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }


    
    public void menu() {
        while (true) {
            System.out.println("\n*** Student Management System ***");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        management.menu();
    }
}
