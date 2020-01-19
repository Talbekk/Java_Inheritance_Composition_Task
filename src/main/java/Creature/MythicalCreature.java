package Creature;

import Behaviours.IDamageable;
import Behaviours.IRoomable;
import Equipments.Equipment;


public abstract class MythicalCreature implements IRoomable, IDamageable {

    int hp;
    Equipment equipment;
    boolean status;


    public MythicalCreature(int hp, Equipment equipment) {
        this.hp = hp;
        this.equipment = equipment;
        this.status = true;
    }

    public int getHP() {
        return hp;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setHP(int hp) {
        this.hp = hp;
        if(this.hp < 0){
            this.hp = 0;
        }
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void attack(IDamageable character) {
        int attackDamage = this.equipment.getDMG();
        int characterHealth = character.getHP();
        int result = characterHealth - attackDamage;
        character.setHP(result);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = !status;
    }
}
