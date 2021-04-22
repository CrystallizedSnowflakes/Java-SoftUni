package heroRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private HeroRepository data;
    private Hero hero;
    private Hero zoro;

    @Before
    public void setUp(){
        this.data = new HeroRepository();
        this.hero = new Hero("Merry", 1);
        this.zoro = new Hero("Zoro", 2);
    }

    //getCount
    @Test
    public void testGetCountWorkProperly(){
        int count = this.data.getCount();
        assertEquals(0, count);
    }

    //create
    @Test(expected = NullPointerException.class)
    public void testCreateWithNullHeroShouldThrowEx(){
        this.data.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSameHeroTwiceShouldThrowEx(){
        String ex = String.format("Hero with name %s already exists", this.hero.getName());
        this.data.create(hero);
        String ac = this.data.create(hero);
        assertEquals(ex, ac);
    }

    @Test
    public void testCreateWorkProperly(){
        String ex = String.format("Successfully added hero %s with level %d", hero.getName(), hero.getLevel());
        String ac = this.data.create(this.hero);
        assertEquals(ex, ac);
    }

    //remove
    @Test(expected = NullPointerException.class)
    public void testRemove(){
        this.data.remove(null);
    }

    @Test
    public void testRemoveWorkProperly(){
        this.data.create(hero);
        this.data.create(zoro);
        boolean ac = this.data.remove("Merry");
        assertTrue(ac);
    }

    //getHeroWithHighestLevel
    @Test
    public void testGetHeroWithHighestLevelWorkProperly(){
        this.data.create(hero);
        this.data.create(zoro);
        Hero heroWithHighestLevel = this.data.getHeroWithHighestLevel();
        assertEquals(zoro, heroWithHighestLevel);
    }

    //getHero
    @Test
    public void testGetHeroByNameWorkProperly(){
        this.data.create(hero);
        this.data.create(zoro);
        Hero ex = this.zoro;
        Hero ac = this.data.getHero("Zoro");
        assertEquals(ex, ac);
    }

    //getHeroes
    @Test(expected = UnsupportedOperationException.class)
    public void testGetHeroesFromEmptyDATAShouldThrowEx(){
        this.data.create(hero);
        this.data.create(zoro);
        Collection<Hero> heroes = this.data.getHeroes();
        heroes.remove(zoro);
    }
}
