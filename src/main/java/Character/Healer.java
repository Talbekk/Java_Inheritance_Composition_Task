package Character;

import Equipments.Equipment;
import Types.ArmourType;

public class Healer extends Character {
    public Healer(int hp, Equipment equipment, ArmourType armour) {
        super(hp, equipment, armour);
        this.setArmour(ArmourType.CLOTH);
    }

    public void heal() {

        if(this.hp < this.startingHealth) {
            int damage = this.equipment.getDMG();
            int initHealth = this.hp;
            int healamount = damage * 2;
            this.setHP(initHealth + healamount);
            if(this.hp > this.startingHealth){
                this.hp = this.startingHealth;
            }
        }

    }

}
