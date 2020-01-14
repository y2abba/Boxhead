import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Increased firerate.
 *
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class MachineGun extends Weapon
{
    public MachineGun() {
        super("Machine Gun", 500);
        setFireRate(5);
        setDamage(15);
        setBulletSpeed(15);
        setSoundFileName("machinegun.wav");
    }
}