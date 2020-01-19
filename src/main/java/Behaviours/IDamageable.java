package Behaviours;

public interface IDamageable {

    public void attack(IDamageable object);

    public int getHP();

    public void setHP(int result);

    public void setStatus();

    public int getStartingHealth();
}
