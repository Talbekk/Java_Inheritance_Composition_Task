package Game;

import Behaviours.IPlayable;
import Room.Room;

import java.util.ArrayList;
import java.util.BitSet;

public class Quest {
    String name;
    ArrayList<Room> rooms;
    ArrayList<IPlayable> characters;
    boolean progress;

    public Quest(String name, IPlayable character){
        this.name = name;
        this.rooms = new ArrayList<Room>();
        this.characters = new ArrayList<IPlayable>();
        this.progress = false;
    }


    public ArrayList<IPlayable> getPlayers() {
        return new ArrayList<IPlayable>(this.characters);
    }

    public void addPlayer(IPlayable hero) {
        this.characters.add(hero);
    }

    public ArrayList<Room> getRoomList() {
        return new ArrayList<Room>(rooms);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void tackleQuest() {
        for (Room currentRoom : this.rooms){
            currentRoom.enterRoom(this.characters);
        }
    }

    public boolean getObjectivesCompleted() {
        for (Room currentRoom : this.rooms){
            if (currentRoom.getObjectiveStatus()){
                this.progress = true;
            } else {
                this.progress = false;
            }
        }
        return this.progress;
    }

    public String getName() {
        return this.name;
    }
}
