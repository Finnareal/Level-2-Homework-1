package Lesson_3;

public class EmptyStackException extends Exception{
    private String exceptionMessage = "Стек пуст!";

    public EmptyStackException(Throwable cause){
        super(cause);
    }

}
