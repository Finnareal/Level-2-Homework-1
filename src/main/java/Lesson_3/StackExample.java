package Lesson_3;

import java.util.LinkedList;

public class StackExample {

    private LinkedList <Raid> stackExample;
    private final int stackSize;

    public StackExample(){
        stackExample = new LinkedList<>();
        stackSize = 4;
    }

    public void push(Raid raid) throws StackOverflowException {
        if (stackExample.size() < stackSize){
            stackExample.add(raid);
        }else {
            throw new StackOverflowException("Стек переполнен!");
        }
    }

    public Raid pop() throws EmptyStackException {
        if (stackExample.isEmpty() == false){
            Raid raidMember = stackExample.getLast();
            stackExample.removeLast();
            return raidMember;
        }else {
            throw new EmptyStackException("Стек не содержит элементов!");
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
