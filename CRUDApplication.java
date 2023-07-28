import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class StudentDatabase {
    private List<Student> students;

    public StudentDatabase() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            System.out.println("Student Database:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(Student updatedStudent) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == updatedStudent.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            students.set(index, updatedStudent);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class CRUDApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDatabase database = new StudentDatabase();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nCRUD Application Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student age: ");
                    int age = sc.nextInt();
                    Student student = new Student(id, name, age);
                    database.addStudent(student);
                    break;
                case 2:
                    database.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int searchId = sc.nextInt();
                    Student foundStudent = database.findStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt();
                    Student updatedStudent = database.findStudentById(updateId);
                    if (updatedStudent != null) {
                        sc.nextLine(); // Consume the newline character
                        System.out.print("Enter updated student name: ");
                        String updatedName = sc.nextLine();
                        System.out.print("Enter updated student age: ");
                        int updatedAge = sc.nextInt();
                        updatedStudent = new Student(updateId, updatedName, updatedAge);
                        database.updateStudent(updatedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();
                    database.deleteStudent(deleteId);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
