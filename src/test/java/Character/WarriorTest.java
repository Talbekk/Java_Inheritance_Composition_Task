package Character;

import Creature.Orc;
import Equipments.Weapon;
import Types.ArmourType;
import Types.TreasureType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarriorTest {

    Warrior warrior;
    Weapon weapon;
    Orc orc;

    @Before
    public void before(){
        weapon = new Weapon("Sword", 10);
        warrior = new Warrior(100, weapon, ArmourType.PLATE);
        orc = new Orc(30, weapon);


    }

    @Test
    public void hasHP(){
        assertEquals(130, warrior.getHP());
    }
    @Test
    public void hasWeapon(){
        assertEquals(weapon, warrior.getEquipment());
    }
    @Test
    public void hasArmour(){
        assertEquals(ArmourType.PLATE, warrior.getArmour());
    }
    @Test
    public void badStartsEmpty(){
        assertEquals(0, warrior.getBag().size());
    }

    @Test
    public void canAttackOrc(){
        warrior.attack(orc);
        assertEquals(20, orc.getHP());
    }
    @Test
    public void checkTheOrcHPCannotGoBelowZero(){
        warrior.attack(orc);
        warrior.attack(orc);
        warrior.attack(orc);
        assertEquals(0, orc.getHP());
    }

    @Test
    public void canAddLoot(){
        warrior.addLoot(TreasureType.GOLD);
        assertEquals(1, warrior.getBag().size());
    }
}
