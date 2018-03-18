package Lesson_3;

public class Raid {
    private String gameClass;
    private String role;

    public Raid(String gameClass, String role){
        this.gameClass = gameClass;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Raid{" +
                "gameClass='" + gameClass + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
