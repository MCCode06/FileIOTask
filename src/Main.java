import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Teachers
            Teacher teacher1 = new Teacher("Khanum", "Jafarova", 45, "Female");
            Teacher teacher2 = new Teacher("Asim", "Namazov", 39, "Male");
            Teacher teacher3 = new Teacher("Azar", "Aliyev", 29, "Male");

            List<Teacher> teachers = Arrays.asList(teacher1, teacher2);

            // Courses
            Course calc = new Course("Calculus", teacher1);
            Course netw = new Course("Network", teacher2);
            Course cs = new Course("Computer Science", teacher3);
            teacher1.canTeach(calc);
            teacher2.canTeach(netw);
            teacher3.canTeach(cs);

            List<Course> courses = Arrays.asList(calc, netw, cs);

            // Students
            List<Student> students = new ArrayList<>();
            students.add(new Student("Sanani", "Zeynalli", 19, "Male"));
            students.add(new Student("Javid", "Nazarov", 19, "Male"));
            students.add(new Student("Seyfulla", "Mehdiyev", 19, "Male"));
            students.add(new Student("Farid", "Mehtiyev", 19, "Non-binary"));
            students.add(new Student("Xagani", "Zeynalli", 20, "Male"));
            students.add(new Student("Keml", "Godgivers", 21, "Male"));

            for (Student student : students) {
                System.out.println("--- " + student.firstName + " " + student.lastName + " ---");
                for (int i = 0; i < 3; i++) {
                    Course course = courses.get(i);
                    student.enroll(course);
                    course.makeExam(student);
                }
                System.out.println('\n');
            }

            writeStudentsToJson(students);
            writeTeachersToJson(teachers);
            writeCoursesToJson(courses);
            writeExamsToJson(students, courses);

            System.out.println("Data successfully written to JSON files.");

        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void writeStudentsToJson(List<Student> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.json"))) {

            writer.write("[\n");
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                writer.write("  {\n");
                writer.write("    \"firstName\": \"" + student.getFirstName() + "\",\n");
                writer.write("    \"lastName\": \"" + student.getLastName() + "\",\n");
                writer.write("    \"age\": " + student.age + ",\n");
                writer.write("    \"gender\": \"" + student.gender + "\",\n");


                writer.write("    \"courses\": [\n");
                for (int j = 0; j < student.getCourses().size(); j++) {
                    Course course = student.getCourses().get(j);
                    writer.write("      \"" + course.getName() + "\"");
                    // this if statement ensures that there is no comma after the last element
                    if (j < student.getCourses().size() - 1) {
                        writer.write(",");
                    }
                    writer.write("\n");
                }
                writer.write("    ],\n");


                writer.write("    \"grades\": {\n");
                int gradeCount = 0; // keep track of how many grades have been written for this particular student
                                    // to avoid placing a comma after the last grade.
                for (Map.Entry<Course, Double> entry : student.getGrades().entrySet()) {
                    writer.write("      \"" + entry.getKey().getName() + "\": " + entry.getValue());
                    gradeCount++;
                    if (gradeCount < student.getGrades().size()) {
                        writer.write(",");
                    }
                    writer.write("\n");
                }
                writer.write("    }\n");
                writer.write("  }");


                if (i < students.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]\n");

        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to students.json: " + e.getMessage());
        }
    }



    private static void writeTeachersToJson(List<Teacher> teachers) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("teachers.json"))) {

            writer.write("[\n");
            for (int i = 0; i < teachers.size(); i++) {
                Teacher teacher = teachers.get(i);
                writer.write("  {\n");
                writer.write("    \"firstName\": \"" + teacher.getFirstName() + "\",\n");
                writer.write("    \"lastName\": \"" + teacher.getLastName() + "\",\n");
                writer.write("    \"age\": " + teacher.age + ",\n");
                writer.write("    \"gender\": \"" + teacher.gender + "\",\n");
                writer.write("    \"courses\": [\n");


                for (int j = 0; j < teacher.getCourses().size(); j++) {
                    Course course = teacher.getCourses().get(j);
                    writer.write("      \"" + course.getName() + "\"");
                    if (j < teacher.getCourses().size() - 1) {
                        writer.write(",");
                    }
                    writer.write("\n");
                }
                writer.write("    ]\n");
                writer.write("  }");


                if (i < teachers.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to teachers.json: " + e.getMessage());
        }
    }


    private static void writeCoursesToJson(List<Course> courses) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("courses.json"))) {

            writer.write("[\n");
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                writer.write("  {\n");
                writer.write("    \"name\": \"" + course.getName() + "\",\n");
                writer.write("    \"teacher\": \"" + course.getTeacher().getFirstName() + " " + course.getTeacher().getLastName() + "\"\n");
                writer.write("  }");
                if (i < courses.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]\n");

        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to courses.json: " + e.getMessage());
        }
    }


    private static void writeExamsToJson(List<Student> students, List<Course> courses) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("exams.json"))) {

            writer.write("[\n");
            for (Student student : students) {
                for (Course course : student.getCourses()) {
                    writer.write("  {\n");
                    writer.write("    \"student\": \"" + student.getFirstName() + " " + student.getLastName() + "\",\n");
                    writer.write("    \"course\": \"" + course.getName() + "\",\n");
                    writer.write("    \"grade\": " + student.getGrades().get(course) + "\n");
                    writer.write("  }");
                    if (student.getCourses().indexOf(course) < student.getCourses().size() - 1 || students.indexOf(student) < students.size() - 1) {
                        writer.write(",");
                    }
                    writer.write("\n");
                }
            }

            writer.write("]\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to exams.json: " + e.getMessage());
        }
    }

}
