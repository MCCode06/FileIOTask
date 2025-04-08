import java.util.*;

public class Teacher extends Human implements Teacherable {
    private List<Course> courses;

    public Teacher(String firstName, String lastName, int age, String gender) {
        super(firstName, lastName, age, gender);
        this.courses = new ArrayList<>();
    }

    @Override
    public void canTeach(Course course) {
        courses.add(course);
        System.out.println(firstName + ' ' + lastName + " is teaching " + course.getName());
    }

    @Override
    public void whoami() {
        System.out.println("I am teacher " + firstName + ' ' + lastName);
    }
}
