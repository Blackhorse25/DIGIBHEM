import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradebook {
    private static Map<String, Student> students = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Gradebook Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View Student Grades");
            System.out.println("5. Generate Grade Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    viewStudentGrades();
                    break;
                case 5:
                    generateGradeReport();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student ID: ");
        String id = scanner.next();

        Student student = new Student(name, id);
        students.put(id, student);
        System.out.println("Student added successfully!");
    }

    private static void editStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.next();

        if (students.containsKey(id)) {
            Student student = students.get(id);
            System.out.print("Enter new name (or press enter to keep current): ");
            String name = scanner.next();
            if (!name.isEmpty()) {
                student.setName(name);
            }

            System.out.print("Enter new grades (separated by commas): ");
            String grades = scanner.next();
            student.setGrades(grades);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.next();

        if (students.containsKey(id)) {
            students.remove(id);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewStudentGrades() {
        System.out.print("Enter student ID: ");
        String id = scanner.next();

        if (students.containsKey(id)) {
            Student student = students.get(id);
            System.out.println("Student Grades:");
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("Average Score: " + student.getAverageScore());
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void generateGradeReport() {
        System.out.println("Grade Report:");
        for (Student student : students.values()) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("Average Score: " + student.getAverageScore());
            System.out.println();
        }
    }

    private static class Student {
        private String name;
        private String id;
        private ArrayList<Double> grades = new ArrayList<>();

        public Student(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setGrades(String grades) {
            this.grades.clear();
            for (String grade : grades.split(",")) {
                this.grades.add(Double.parseDouble(grade));
            }
        }

        public String getGrades() {
            StringBuilder gradesStr = new StringBuilder();
            for (Double grade : grades) {
                gradesStr.append(grade).append(", ");
            }
            return gradesStr.toString().trim().replaceAll(", $", "");
        }

        public double getAverageScore() {
            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            return sum / grades.size();
        }
    }
}