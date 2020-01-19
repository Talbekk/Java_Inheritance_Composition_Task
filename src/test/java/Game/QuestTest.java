package Game;
import Character.Warrior;
import Character.SpellCaster;
import Creature.Orc;
import Creature.Dragon;


import Equipments.Weapon;
import Equipments.Spell;
import Room.Room;
import Types.ArmourType;
import Types.TreasureType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QuestTest {

    Quest quest;
    Warrior warrior;
    SpellCaster spellcaster;
    Weapon weapon;
    Orc orc;
    Room room;
    Spell spell;
    Dragon dragon;

    @Before
    public void before(){
        weapon = new Weapon("Long Sword", 20);
        spell = new Spell("Fireball", 40);
        warrior =  new Warrior(100, weapon, ArmourType.PLATE);
        dragon = new Dragon(30, spell);
        spellcaster = new SpellCaster(40, spell, ArmourType.CLOTH, dragon);
        orc = new Orc(50, weapon);
        room = new Room(TreasureType.GEM);
        quest = new Quest(warrior);

    }

    @Test
    public void checkTheQuestCanHaveAPlayer(){
        assertEquals(warrior, quest.getPlayer());
    }

    @Test
    public void checkThereAreRooms(){
        assertEquals(0, quest.getRoomList().size());
    }
    @Test
    public void canAddRoomsToTheQuest(){
        quest.addRoom(room);
        assertEquals(1, quest.getRoomList().size());
    }
    @Test public void checkThatThePlayerCanChange(){
        quest.addPlayer(spellcaster);
        assertEquals(spellcaster, quest.getPlayer());
    }







}
