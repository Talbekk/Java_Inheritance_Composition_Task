package Room;

import Behaviours.IPlayable;
import Character.Warrior;
import Creature.Orc;
import Equipments.Weapon;
import Types.ArmourType;
import Types.TreasureType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {

    Room room;
    Room room2;
    Orc orc;
    Warrior warrior;
    Weapon weapon;
    Weapon axe;


    @Before
    public void before(){

        axe = new Weapon("Axe", 20);
        orc = new Orc(50, axe);
        room = new Room();
        room.addObjective(TreasureType.GEM);
        room2 = new Room();
        room2.addObjective(orc);
        weapon = new Weapon("BattleAxe", 40);
        warrior = new Warrior(100, weapon, ArmourType.PLATE);

    }

    @Test
    public void hasAMissionInRoom(){
        assertTrue(room.getObjectives().contains(TreasureType.GEM));
    }

    @Test
    public void canAddObjectivesToRoom(){
        assertEquals(1, room.getObjectives().size());
        assertEquals(1, room2.getObjectives().size());
    }

    @Test
    public void canCheckChestHasTreasure(){
        assertEquals(1, room.getChest().size() );
    }
    @Test
    public void canChangeCompletedStatus(){
        room.completeQuest();
        assertTrue(room.getObjectiveStatus());

    }
    @Test
    public void canRemoveTreasureFromChest(){
        room.emptyChest();
        assertEquals(0, room.getChest().size());
    }
    @Test
    public void roomCanHaveACreatureToFight(){
        assertTrue(room2.getObjectives().contains(orc));
    }
    @Test
    public void heroCanLootTreasureInARoom(){
        room.enterRoom(warrior);
        assertEquals(0, room.getChest().size());
        assertEquals(1, warrior.getBag().size());
    }
    @Test
    public void heroCanDefeatCreatureInRoom(){
        room2.enterRoom(warrior);
        assertFalse(orc.getStatus());
    }

    @Test
    public void heroKeepsDamageWhenFinishesCombat(){
        int startingHealth = warrior.getHP();
        room2.enterRoom(warrior);
        assertTrue(startingHealth != warrior.getHP());
    }

    @Test
    public void heroCanCompleteRoom(){
        room2.enterRoom(warrior);
        assertTrue(room2.getObjectiveStatus());
    }

    @Test
    public void hasTreasureAndCreatureInRoom(){
        room = new Room();
        room.addObjective(orc);
        room.addObjective(TreasureType.GEM);
        assertEquals(2, room.getObjectives().size());
    }

    @Test
    public void canCompleteARoomWithMoreThanOneObjective(){
        room = new Room();
        room.addObjective(orc);
        room.addObjective(TreasureType.GEM);
        room.enterRoom(warrior);
        assertTrue(room.getObjectiveStatus());
    }
}
