package Lesson_2;

public class Square {
    @RandomInt(min = 2, max = 8)
    private int width;

    @RandomInt(min = 2, max = 6)
    private int length;

    private Square(){}

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
