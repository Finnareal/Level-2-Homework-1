package Lesson_3;

import org.junit.jupiter.api.*;

public class StackExampleTest {

    private static StackExample fullStackExample;
    private static StackExample emptyStackExample;

    @BeforeAll
    public static void setup(){
        emptyStackExample = new StackExample();
        fullStackExample = new StackExample();
        fullStackExample.getStackExample().add(new Raid("Warrior", "Tank"));
        fullStackExample.getStackExample().add(new Raid("Shaman", "Healer"));
        fullStackExample.getStackExample().add(new Raid("Hunter", "DPS"));
        fullStackExample.getStackExample().add(new Raid("Mage", "DPS"));
        fullStackExample.getStackExample().add(new Raid("Rogue", "DPS"));
    }

    //stackPushTest_newRaid_throwStackOverflowException
    @Test
    public void stackPushTest() throws StackOverflowException {
        Raid raid = new Raid("Druid", "Tank");
        Assertions.assertThrows(StackOverflowException.class, () -> {fullStackExample.push(raid);}, "Стек переполнен!");
    }

    //stackPopTest_throwEmptyStackException
    @Test
    public void stackPopTest() throws EmptyStackException {
        Assertions.assertThrows(EmptyStackException.class, () -> {emptyStackExample.pop();}, "Стек не содержит элементов!");
    }

    @AfterAll
    public static void afterAll() throws StackOverflowException, EmptyStackException {
        Raid raid = new Raid("Druid", "Tank");
        emptyStackExample.push(raid);
        System.out.println(emptyStackExample.getStackExample().getLast());
        System.out.println(fullStackExample.pop());
    }

}
