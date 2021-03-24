package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 13;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp(){
        this.aliveDummy = new Dummy(HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(0, EXPERIENCE);
    }

    //•	Dummy loses health if attacked
    @Test
    public void testDummyLosesHealthWhenIsAttacked(){
        int attack = 3;
        this.aliveDummy.takeAttack(attack);
        int expectedHealthAfterAnAttack = HEALTH - attack;
        assertEquals(expectedHealthAfterAnAttack, this.aliveDummy.getHealth());
    }

    //•	Dead Dummy throws exception if attacked
    @Test(expected = IllegalStateException.class) // Assert
    public void testDeadDummyFailsWhenAttacked(){
        this.deadDummy.takeAttack(3);
    }

    //•	Dead Dummy can give XP
    @Test
    public void testDeadDummyGivesExperience(){
        int actualExperience = this.deadDummy.giveExperience();
        assertEquals(EXPERIENCE, actualExperience);
    }

    //•	Alive Dummy can't give XP
    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoesNotGiveExperience(){
        this.aliveDummy.giveExperience();
    }
}
