package Game;
import Character.Warrior;
import Character.Healer;
import Character.SpellCaster;
import Creature.Basilisk;
import Creature.Ogre;
import Creature.Orc;
import Creature.Dragon;


import Equipments.Weapon;
import Equipments.Spell;
import Equipments.Potion;
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
    Healer healer;
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
    Potion potion;

    @Before
    public void before(){
        weapon = new Weapon("Long Sword", 20);
        spell = new Spell("Fireball", 40);
        potion = new Potion("Shadow Elixir", 25);
        warrior =  new Warrior(100, weapon, ArmourType.PLATE);
        healer = new Healer(40, potion, ArmourType.CLOTH);
        dragon = new Dragon(30, spell);
        spellcaster = new SpellCaster(40, spell, ArmourType.CLOTH, dragon);
        orc = new Orc(50, weapon);
        basilisk = new Basilisk(50, spell);
        ogre = new Ogre(75, weapon);
        room = new Room();
        room.addObjective(TreasureType.GEM);
        room2 = new Room();
        room2.addObjective(orc);
        quest = new Quest("The Trials and Tribulations of E35", warrior);
        room3 = new Room();
        room3.addObjective(basilisk);
        room4 = new Room();
        room4.addObjective(ogre);
        quest.addPlayer(warrior);

    }

    @Test
    public void hasName(){
        assertEquals("The Trials and Tribulations of E35", quest.getName());
    }

    @Test
    public void checkTheQuestCanHaveAPlayer(){
        assertEquals(1, quest.getPlayers().size());
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
        assertTrue( quest.getPlayers().contains(spellcaster));
    }

    @Test
    public void checkThatAPlayerCanClearRoom(){
        quest.addRoom(room);
        quest.tackleQuest();
        assertTrue(room.getObjectiveStatus());
    }

    @Test
    public void checkThatAPlayerCanClearRoomWithACreature(){
        quest.addRoom(room2);
        quest.tackleQuest();
        assertTrue(room2.getObjectiveStatus());
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

    @Test
    public void canAddMultiplePlayersToAQuest(){
    quest.addRoom(room2);
    quest.tackleQuest();
    }

    @Test
    public void canCompleteQuestWithMultiplePlayers(){
        quest.addRoom(room);
        quest.addRoom(room2);
        quest.addPlayer(warrior);
        quest.addPlayer(healer);
        quest.tackleQuest();
        assertTrue(quest.getObjectivesCompleted());
    }
}
