import java.util.*;

public abstract class Human {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String gender;

    public Human(String firstName, String lastName, int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract void whoami();
}
