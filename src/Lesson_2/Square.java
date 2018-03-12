package Lesson_2;

public class Square {
    @RandomInt(min = 2, max = 8)
    private int width = 1;

    @RandomInt(min = 2, max = 6)
    private int length = 1;

    private Square(){}

    public int getSquare(){
        int square = width * length;
        return square;
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
