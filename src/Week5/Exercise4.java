import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

class Student {
    private String name;
    private int id;
    private double grade;

    public Student() {
        name = "";
        id = 0;
        grade = 0.0;
    }

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Name=" + name + ", id=" + id + ", grade=" + grade + "]";
    }

}

class StudentIO {
    public static ArrayList<Student> readStudentData(String filename) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String fullname = scanner.next();
                String id = scanner.next();
                String grade = scanner.next();
                students.add(new Student(fullname, Integer.parseInt(id), Double.parseDouble(grade)));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void writeStudentData(String filename, ArrayList<Student> students) {
        try {
            PrintWriter writer = new PrintWriter(new File(filename));
            for (Student student : students) {
                writer.println(student.getName() + "\t" + student.getId() + "\t" + student.getGrade());
            }
            // calculate the average grade
            double sum = 0;
            for (Student student : students) {
                sum += student.getGrade();
            }
            double average = sum / students.size();
            writer.println("Average grade: " + average);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class StudentManager {
    public static void addStudent(ArrayList<Student> students) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String name = scanner.next();
            System.out.print("Enter student id: ");
            String id = scanner.next();
            System.out.print("Enter student grade: ");
            String grade = scanner.next();
            students.add(new Student(name, Integer.parseInt(id), Double.parseDouble(grade)));
            scanner.close();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

    public static void deleteStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student id: ");
        int id = scanner.nextInt();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                break;
            }
        }
        scanner.close();
    }

    public static void updateStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student id: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter student name: ");
                String name = scanner.next();
                System.out.print("Enter student grade: ");
                String grade = scanner.next();
                student.setName(name);
                student.setGrade(Double.parseDouble(grade));
                break;
            }
        }
        scanner.close();
    }

    public static void displayStudent(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void sortStudentByName(ArrayList<Student> students) {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }

    public static void searchStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                System.out.println(student);
            }
        }
        scanner.close();
    }
}

class GradeManager {
    public static void highestGrade(ArrayList<Student> students) {
        double highest = 0;
        for (Student student : students) {
            if (student.getGrade() > highest) {
                highest = student.getGrade();
            }
        }
        System.out.println("Highest grade: " + highest);
    }

    public static void lowestGrade(ArrayList<Student> students) {
        double lowest = 10.0;
        for (Student student : students) {
            if (student.getGrade() < lowest) {
                lowest = student.getGrade();
            }
        }
        System.out.println("Lowest grade: " + lowest);
    }

    public static void medianGrade(ArrayList<Student> students) {
        ArrayList<Double> grades = new ArrayList<>();
        for (Student student : students) {
            grades.add(student.getGrade());
        }
        Collections.sort(grades);
        int middle = grades.size() / 2;
        if (grades.size() % 2 == 1) {
            System.out.println("Median grade: " + grades.get(middle));
        } else {
            System.out.println("Median grade: " + (grades.get(middle - 1) + grades.get(middle)) / 2.0);
        }
    }

}

public class Exercise4 {
    public static void main(String[] args) {
        ArrayList<Student> students = StudentIO.readStudentData("src/Week5/grade.txt");
        StudentIO studentIO = new StudentIO();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add student      2. Delete student          3. Update student");
            System.out.println("4. Display student  5. Sort student by name    6. Search student");
            System.out.println("7. Highest grade    8. Lowest grade            9. Median grade");
            System.out.println("                    10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> StudentManager.addStudent(students);
                case 2 -> StudentManager.deleteStudent(students);
                case 3 -> StudentManager.updateStudent(students);
                case 4 -> StudentManager.displayStudent(students);
                case 5 -> StudentManager.sortStudentByName(students);
                case 6 -> StudentManager.searchStudent(students);
                case 7 -> GradeManager.highestGrade(students);
                case 8 -> GradeManager.lowestGrade(students);
                case 9 -> GradeManager.medianGrade(students);
                case 10 -> {
                    scanner.close();
                    studentIO.writeStudentData("src/Week5/studentoutput.txt", students);
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}