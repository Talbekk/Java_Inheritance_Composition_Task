package Character;

import Creature.Dragon;
import Creature.Ogre;
import Equipments.Spell;
import Equipments.Weapon;
import Types.ArmourType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpellCasterTest {

    SpellCaster spellCaster;
    Spell spell;
    Dragon dragon;
    Ogre ogre;
    Weapon weapon;
    Spell spell2;

    @Before
    public void before(){
        spell = new Spell("Fireball", 50);
        dragon = new Dragon(50, spell);
        spellCaster = new SpellCaster(100, spell, ArmourType.CLOTH, dragon);
        weapon = new Weapon("Broadsword", 25);
        ogre = new Ogre(100, weapon);
        spell2 = new Spell("Frostbolt", 40);
    }

    @Test
    public void hasDragon(){
        assertEquals(dragon, spellCaster.getCompanion());
    }

    @Test
    public void canAddACompanion(){
        spellCaster.addCompanion(ogre);
        assertEquals(ogre, spellCaster.getCompanion());
    }

    @Test
    public void canChangeSpell(){
        spellCaster.setEquipment(spell2);
        assertEquals("Frostbolt", spellCaster.getEquipment().getName());
    }

    @Test
    public void canAttackCombinedWithCompanion(){
        spellCaster.attack(ogre);
        assertEquals(0, ogre.getHP());
    }
}

