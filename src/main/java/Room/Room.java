package Room;

import Behaviours.IDamageable;
import Behaviours.IPlayable;
import Behaviours.IRoomable;
import Creature.MythicalCreature;
import Creature.Orc;
import Types.TreasureType;

import java.util.ArrayList;

public class Room {

    private ArrayList<IRoomable> objectives;
    private ArrayList<TreasureType> chest;
    private boolean status;

    public Room() {
        this.objectives = new ArrayList<IRoomable>();
        this.chest = new ArrayList<TreasureType>();
        this.status = false;
    }

    public ArrayList<IRoomable> getObjectives() {
        return new ArrayList<IRoomable>(objectives);
    }

    public ArrayList<TreasureType> getChest() {
        return new ArrayList<TreasureType>(chest);
    }

    public boolean getObjectiveStatus(){ return this.status; }

    public void completeQuest() {
        this.status = true;
    }

    public void emptyChest() { this.chest.clear(); }

    public TreasureType getTreasure(){
        return this.chest.remove(0);
    }

    public void enterRoom(IPlayable hero) {

            for (IRoomable currentObjective : this.objectives) {
                if (currentObjective instanceof MythicalCreature) {
                    this.resolveFight((IDamageable) currentObjective, (IDamageable) hero);
                }
                if (this.getChest().size() > 0) {
                    TreasureType reward = this.getTreasure();
                    hero.addLoot(reward);
                    this.emptyChest();
                }
                if (hero.getStatus()) {
                    this.completeQuest();
                }
            }


        }

    private void resolveFight(IDamageable creature, IDamageable hero) {
        while(creature.getHP() > 0 && hero.getHP() > 0) {
            hero.attack(creature);
            if (creature.getHP() > 0) {
                creature.attack(hero);
            }
        }
         if (creature.getHP() <= 0) {
             creature.setStatus();
         } else {
             if (hero.getHP() <= 0) {
                 hero.setStatus();
             }
         }
    }

    public void addObjective(IRoomable objective) {
        this.objectives.add(objective);
        for (IRoomable currentObjective : this.objectives) {
            if (currentObjective instanceof TreasureType) {
                chest.add((TreasureType) currentObjective);
            }
        }
    }
}
