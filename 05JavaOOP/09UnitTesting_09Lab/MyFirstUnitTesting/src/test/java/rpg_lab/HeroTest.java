package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {
    private static final int TARGET_XP = 13;

    // Test if hero gains XP when target dies
    @Test
    public void testHeroGainsExperienceWhenTargetDies(){
        Weapon weapon = mock(Weapon.class); // used as a blueprint, no methods
        Hero hero = new Hero("Java_Wizard", weapon);

        Target target = mock(Target.class);
        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(TARGET_XP);

        hero.attack(target);

        assertEquals(TARGET_XP, hero.getExperience());
    }

    /*private static class TestWeapon implements Weapon{ // Anonymous class
        @Override
        public int getAttackPoints() {
            return 0;
        }
        @Override
        public int getDurabilityPoints() {
            return 0;
        }
        @Override
        public void attack(Target target) {

        }
    }

    private static class TestTarget implements Target{ // Anonymous class
        @Override
        public int getHealth() {
            return 0;
        }
        @Override
        public void takeAttack(int attackPoints) {
        }
        @Override
        public int giveExperience() {
            return 13;
        }
        @Override
        public boolean isDead() {
            return true;
        }
    }

    // Test if hero gains XP when target dies

    @Test
    public void testHeroGainsExperienceWhenTargetDies(){
        Hero hero = new Hero("Java_Wizard", new TestWeapon());

        hero.attack(new TestTarget());

        assertEquals(13, hero.getExperience());
    }*/
}