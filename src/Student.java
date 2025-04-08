import java.util.*;

public class Student extends Human {
    private List<Course> courses;
    private Map<Course, Double> grades;

    public Student(String firstName, String lastName, int age, String gender) {
        super(firstName, lastName, age, gender);
        this.courses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public void enroll(Course course) {
        courses.add(course);
    }

    public void addGrade(Course course, double grade) {
        grades.put(course, grade);
    }

    public Map<Course, Double> getGrades() {
        return grades;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public void whoami() {
        System.out.println("I am student: " + firstName + ' ' + lastName);
    }
}
