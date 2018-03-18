package Lesson_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackExampleTest {

    private StackExample fullStackExample;
    private StackExample emptyStackExample;


    @BeforeEach
    public void setup(){
        this.emptyStackExample = new StackExample();
        this.fullStackExample = new StackExample();
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
        //fullStackExample.push(raid);
        Assertions.assertThrows(StackOverflowException.class, () -> {fullStackExample.push(raid);}, "Стек переполнен!");

    }


}
