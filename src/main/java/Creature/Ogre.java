package Creature;

import Behaviours.ICompanianble;
import Behaviours.IDamageable;
import Equipments.Equipment;

public class Ogre extends MythicalCreature implements ICompanianble {
    public Ogre(int hp, Equipment equipment) {
        super(hp, equipment);
    }
}
