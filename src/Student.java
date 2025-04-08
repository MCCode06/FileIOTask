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
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }
        if (courses.contains(course)) {
            System.out.println(firstName + " " + lastName + " is already enrolled in " + course.getName());
        } else {
            courses.add(course);
            System.out.println(firstName + " " + lastName + " has enrolled in " + course.getName());
        }
    }

    public void addGrade(Course course, double grade) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
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
