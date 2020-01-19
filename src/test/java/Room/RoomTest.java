package Room;

import Behaviours.IPlayable;
import Character.Healer;
import Character.Warrior;
import Creature.Orc;
import Equipments.Potion;
import Equipments.Weapon;
import Types.ArmourType;
import Types.TreasureType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RoomTest {

    Room room;
    Room room2;
    Orc orc;
    Warrior warrior;
    Weapon weapon;
    Weapon axe;
    Healer healer;
    Potion potion;
    ArrayList<IPlayable> player;
    ArrayList<IPlayable> players;


    @Before
    public void before(){

        axe = new Weapon("Axe", 20);
        potion = new Potion("Shadow Elixir", 25);
        orc = new Orc(50, axe);
        room = new Room();
        room.addObjective(TreasureType.GEM);
        room2 = new Room();
        room2.addObjective(orc);
        weapon = new Weapon("BattleAxe", 40);
        warrior = new Warrior(100, weapon, ArmourType.PLATE);
        healer = new Healer(50, potion, ArmourType.CLOTH);
//        ArrayList<IPlayable> players = new ArrayList<IPlayable>();
//        ArrayList<IPlayable> player = new ArrayList<IPlayable>();
//        players.add(warrior);
//        players.add(healer);
//        player.add(warrior);

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
        ArrayList<IPlayable> player = new ArrayList<IPlayable>();
        player.add(warrior);
        room.enterRoom(player);
        assertEquals(0, room.getChest().size());
        assertEquals(1, warrior.getBag().size());
    }
    @Test
    public void heroCanDefeatCreatureInRoom(){
        ArrayList<IPlayable> player = new ArrayList<IPlayable>();
        player.add(warrior);
        room2.enterRoom(player);
        assertFalse(orc.getStatus());
    }

    @Test
    public void heroKeepsDamageWhenFinishesCombat(){
        ArrayList<IPlayable> player = new ArrayList<IPlayable>();
        player.add(warrior);
        int startingHealth = warrior.getHP();
        room2.enterRoom(player);
        assertTrue(startingHealth != warrior.getHP());
    }

    @Test
    public void heroCanCompleteRoom(){
        ArrayList<IPlayable> player = new ArrayList<IPlayable>();
        player.add(warrior);
        room2.enterRoom(player);
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
        ArrayList<IPlayable> player = new ArrayList<IPlayable>();
        player.add(warrior);
        room = new Room();
        room.addObjective(orc);
        room.addObjective(TreasureType.GEM);
        room.enterRoom(player);
        assertTrue(room.getObjectiveStatus());
    }

    @Test
    public void canEnterTwoPlayersIntoRoom(){
        ArrayList<IPlayable> players = new ArrayList<IPlayable>();
        players.add(warrior);
        players.add(healer);
        room.enterRoom(players);
        assertTrue(room.getObjectiveStatus());
    }
}
