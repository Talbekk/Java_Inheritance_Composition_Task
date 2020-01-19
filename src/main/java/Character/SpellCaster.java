package Character;

import Behaviours.ICompanianble;
import Behaviours.IDamageable;
import Creature.Dragon;
import Creature.MythicalCreature;
import Creature.Ogre;
import Equipments.Equipment;
import Equipments.Spell;
import Types.ArmourType;

public class SpellCaster extends Character {

    private MythicalCreature mythicalCreature;
    public SpellCaster(int hp, Equipment equipment, ArmourType armour, MythicalCreature mythicalCreature) {
        super(hp, equipment, armour);
        this.mythicalCreature = mythicalCreature;

        this.setArmour(ArmourType.CLOTH);
    }

    public MythicalCreature getCompanion() {
        return this.mythicalCreature;
    }


    public void addCompanion(MythicalCreature companion) {
        if (companion instanceof ICompanianble){
            this.mythicalCreature = companion;
        }
    }

    public void attack(IDamageable creature){
            int attackDamage = this.equipment.getDMG() + this.mythicalCreature.getEquipment().getDMG();
            int creatureHealth = creature.getHP();
            int result = creatureHealth - attackDamage;
            creature.setHP(result);

    }

    public void setHP(int hp) {
        MythicalCreature companion = this.mythicalCreature;
        if (companion.getHP() > 0) {
            companion.setHP(hp);
            if (companion.getHP() < 0){
                companion.setHP(0);
            }
        } else {
            this.hp = hp;
            if (this.hp < 0) {
                this.hp = 0;
            }
        }
    }


}
