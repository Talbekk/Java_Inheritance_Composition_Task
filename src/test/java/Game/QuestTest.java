package Game;
import Character.Warrior;
import Character.SpellCaster;
import Creature.Basilisk;
import Creature.Ogre;
import Creature.Orc;
import Creature.Dragon;


import Equipments.Weapon;
import Equipments.Spell;
import Room.Room;
import Types.ArmourType;
import Types.TreasureType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class QuestTest {

    Quest quest;
    Warrior warrior;
    SpellCaster spellcaster;
    Weapon weapon;
    Orc orc;
    Room room;
    Spell spell;
    Dragon dragon;
    Room room2;
    Room room3;
    Room room4;
    Basilisk basilisk;
    Ogre ogre;

    @Before
    public void before(){
        weapon = new Weapon("Long Sword", 20);
        spell = new Spell("Fireball", 40);
        warrior =  new Warrior(100, weapon, ArmourType.PLATE);
        dragon = new Dragon(30, spell);
        spellcaster = new SpellCaster(40, spell, ArmourType.CLOTH, dragon);
        orc = new Orc(50, weapon);
        basilisk = new Basilisk(50, spell);
        ogre = new Ogre(75, weapon);
        room = new Room(TreasureType.GEM);
        room2 = new Room(orc);
        quest = new Quest("The Trials and Tribulations of E35", warrior);
        room3 = new Room(basilisk);
        room4 = new Room(ogre);

    }

    @Test
    public void hasName(){
        assertEquals("The Trials and Tribulations of E35", quest.getName());
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
    @Test
    public void checkThatThePlayerCanChange(){
        quest.addPlayer(spellcaster);
        assertEquals(spellcaster, quest.getPlayer());
    }

    @Test
    public void checkThatAPlayerCanClearRoom(){
        quest.addRoom(room);
        quest.tackleQuest();
        assertTrue(room.missionStatus());
    }

    @Test
    public void checkThatAPlayerCanClearRoomWithACreature(){
        quest.addRoom(room2);
        quest.tackleQuest();
        assertTrue(room2.missionStatus());
    }

    @Test
    public void canCompleteMultipleRoomsInQuest(){
        quest.addRoom(room);
        quest.addRoom(room2);
        quest.tackleQuest();
        assertTrue(quest.getObjectivesCompleted());
    }

    @Test
    public void canFailAQuest(){
        quest.addRoom(room2);
        quest.addRoom(room3);
        quest.addRoom(room4);
        quest.tackleQuest();
        assertFalse(quest.getObjectivesCompleted());
    }
}
