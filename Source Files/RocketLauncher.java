import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fires a rocket.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class RocketLauncher extends Weapon
{
    public RocketLauncher() {
        super("Rocket Launcher", 30);
        setFireRate(100);
        setDamage(0);
        setBulletSpeed(20);
        setSoundFileName("rocketlauncher.wav");
    }
    
    @Override
    public void fire() {
        if(fireRateCount == 0) {
            if(ammo > 0) {
                Rocket rocket = new Rocket(getHolder().getDirection(), getHolder());
                rocket.setDamage(getDamage());
                getWorld().addObject(rocket, getHolder().getX(), getHolder().getY());
                fireRateCount = fireRate;
                ammo--;
                Greenfoot.playSound(soundFile);
            }
        }
    }
}
