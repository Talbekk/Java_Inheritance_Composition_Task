package Character;


import Creature.Orc;
import Equipments.Potion;
import Equipments.Weapon;
import Types.ArmourType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HealerTest {

    Healer healer;
    Potion potion;
    Orc orc;
    Weapon weapon;

    @Before
    public void before(){
        potion = new Potion("Elixir", 10);
        healer = new Healer(50, potion, ArmourType.CLOTH);
        weapon = new Weapon("Axe", 25);
        orc = new Orc(20, weapon);
    }

    @Test
    public void canHeal(){
    orc.attack(healer);
    healer.heal();
    assertEquals(46, healer.getHP());
    }

    @Test
    public void startingHealthMeterDoesNotChange(){
        int health = healer.getStartingHealth();
        orc.attack(healer);
        assertTrue(health != healer.getHP());
    }

    @Test
    public void cannotHealPastStartingHP(){
        orc.attack(healer);
        healer.heal();
        healer.heal();
        healer.heal();
        assertEquals(51, healer.getHP());
    }


}
