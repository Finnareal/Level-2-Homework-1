package Lesson_2;

public class User {
    private String name = "";
    private String lastName = "";

    @RandomInt(min = 18, max = 80)
    private int age;

    @RandomInt(min = 0, max = 5)
    private int childrenCount = 0;

    private User(){}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", childrenCount=" + childrenCount +
                '}';
    }
}
