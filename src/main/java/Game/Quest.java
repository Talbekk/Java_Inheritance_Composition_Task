package Game;

import Behaviours.IPlayable;
import Room.Room;

import java.util.ArrayList;
import java.util.BitSet;

public class Quest {
    ArrayList<Room> rooms;
    IPlayable character;

    public Quest(IPlayable character){
        this.rooms = new ArrayList<Room>();
        this.character = character;
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
}
