package Game;

import Behaviours.IPlayable;
import Room.Room;

import java.util.ArrayList;
import java.util.BitSet;

public class Quest {
    String name;
    ArrayList<Room> rooms;
    IPlayable character;
    boolean progress;

    public Quest(String name, IPlayable character){
        this.name = name;
        this.rooms = new ArrayList<Room>();
        this.character = character;
        this.progress = false;
    }


    public IPlayable getPlayer() {
        return this.character;
    }

    public void addPlayer(IPlayable hero) {
        this.character = hero;
    }

    public ArrayList<Room> getRoomList() {
        return new ArrayList<Room>(rooms);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void tackleQuest() {
        for (Room currentRoom : this.rooms){
            currentRoom.enterRoom(this.character);
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
