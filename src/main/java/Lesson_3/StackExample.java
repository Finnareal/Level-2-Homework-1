package Lesson_3;

import java.util.LinkedList;

public class StackExample {

    private LinkedList <Raid> stackExample;
    private final int stackSize;

    public StackExample(){
        stackExample = new LinkedList<Raid>();
        stackSize = 4;
    }

    public void push(Raid raid) throws StackOverflowException {
        if (stackExample.size() < stackSize){
            stackExample.add(raid);
        }else {
            throw new StackOverflowException("Стек переполнен!");
            //System.out.println("Переполнение стека!");
        }

    }

    public LinkedList<Raid> getStackExample() {
        return stackExample;
    }

    @Override
    public String toString() {
        return "StackExample{" +
                "stackExample=" + stackExample +
                '}';
    }
}
