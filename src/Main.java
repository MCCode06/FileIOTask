import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Teachers
        Teacher teacher1 = new Teacher("Khanum", "Jafarova", 35, "Female");
        Teacher teacher2 = new Teacher("Asim", "Namazov", 42, "Male");

        // Courses
        Course calc = new Course("Calculus", teacher1);
        Course netw = new Course("Network", teacher2);
        teacher1.canTeach(calc);
        teacher2.canTeach(netw);

        List<Course> availableCourses = Arrays.asList(calc, netw);

        // Students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Sanani", "Zeynalli", 19, "Male"));
        students.add(new Student("Javid", "Nazarov", 19, "Male"));
        students.add(new Student("Seyfulla", "Mehdiyev", 19, "Male"));
        students.add(new Student("Farid", "Mehtiyev", 19, "Non-binary"));
        students.add(new Student("Xagani", "Zeynalli", 20, "Male"));


        for (Student student : students) {
            System.out.println("--- " + student.firstName + " " + student.lastName + " ---");
            for (int i = 0; i < 2; i++) {
                Course course = availableCourses.get(i);
                student.enroll(course);
                course.makeExam(student);
            }
            System.out.println('\n');
        }

        System.out.println('\n');
        System.out.println("====== STUDENT GRADES ======");
        for (Student student : students) {
            System.out.println("Grades for " + student.firstName + " " + student.lastName + ":");
            for (Course course : availableCourses) {
                Double grade = student.getGrades().get(course);
                if (grade != null) {
                    System.out.println(course.getName() + ": " + grade);
                }
            }
            System.out.println('\n');
        }
    }
}
