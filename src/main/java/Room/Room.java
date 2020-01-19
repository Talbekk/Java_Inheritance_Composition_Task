package Room;

import Behaviours.IDamageable;
import Behaviours.IPlayable;
import Behaviours.IRoomable;
import Creature.MythicalCreature;
import Types.TreasureType;

import java.util.ArrayList;

public class Room {

    private IRoomable mission;
    private ArrayList<TreasureType> chest;
    private boolean status;

    public Room(IRoomable mission) {
        this.mission = mission;
        this.chest = new ArrayList<TreasureType>();
        if (mission instanceof TreasureType){
            chest.add((TreasureType) mission);
        }
        this.status = false;
    }

    public IRoomable getMission() {
        return this.mission;
    }

    public ArrayList<TreasureType> getChest() {
        return new ArrayList<TreasureType>(chest);
    }

    public boolean missionStatus(){ return this.status; }

    public void completeQuest() {
        this.status = !this.status;
    }

    public void emptyChest() { this.chest.clear(); }

    public TreasureType getTreasure(){
        return this.chest.remove(0);
    }

    public void enterRoom(IPlayable hero) {


        if (this.getMission() instanceof MythicalCreature){
            this.resolveFight((IDamageable)this.getMission(), (IDamageable)hero);
        }
        if (this.getChest().size() > 0) {
            TreasureType reward = this.getTreasure();
            hero.addLoot(reward);
            this.emptyChest();
        }

        this.completeQuest();


        }

    private void resolveFight(IDamageable creature, IDamageable hero) {
        while(creature.getHP() > 0){
            hero.attack(creature);
            creature.attack(hero);
        }
        creature.setStatus();
    }
}
