import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Default weapon.
 *
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class Pistol extends Weapon
{
    public Pistol() {
        super("Pistol", -1);
        setFireRate(20);
        setBulletSpeed(10);
        setDamage(15);
        setSoundFileName("pistol.wav");
    }
}