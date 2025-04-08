import java.util.*;

public class Course {
    private String name;
    private Teacher teacher;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public void makeExam(Student student) {
        Exam exam = new Exam(student, this);
        double grade;

        Random rand = new Random();
        int dice = rand.nextInt(6) + 1;
        if (dice == 6) {
            grade = exam.alvinEvaluates();
        }
        else {
            grade = exam.evaluate();
        }
        grade = (double) (Math.round(grade * 100)) / 100; // learned from gpt
        student.addGrade(this, grade);
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
