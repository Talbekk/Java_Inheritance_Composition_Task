package Character;

import Behaviours.IDamageable;
import Behaviours.IPlayable;
import Equipments.Equipment;
import Types.ArmourType;
import com.sun.xml.internal.bind.v2.model.core.ID;

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

    public void healPlayer(IDamageable player) {

        int initHealth = player.getHP();
        int startingHP = player.getStartingHealth();
        if(initHealth < startingHP) {
            int damage = this.equipment.getDMG();
            int healamount = damage * 2;
            player.setHP(initHealth + healamount);
            if(player.getHP() > startingHP){
                player.setHP(startingHP);
            }
        }

    }
}
