import java.util.*;

public class Exam implements Gradable{
    private Student student;
    private Course course;

    public Exam(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    @Override
    public double evaluate() {
        double grade = new Random().nextDouble() * 100;
        while (grade < 70){
            grade = new Random().nextDouble() * 100;
        }
        grade = (double) Math.round(grade * 100) / 100;
        System.out.println(student.getFirstName() + ' ' + student.getLastName() + " is graded for course -> " + course.getName() + ": " + grade);
        return grade;
    }

    @Override
    public double alvinEvaluates(){
        double grade = new Random().nextDouble() * 100;
        while (grade > 60 || grade < 30) {
            grade = new Random().nextDouble() * 100;
        }
        grade = (double) Math.round(grade * 100) / 100;
        System.out.println(student.getFirstName() + ' ' + student.getLastName() + " is graded for course by the Alvin method -> " + course.getName() + ": " + grade);
        return grade;
    }
}
