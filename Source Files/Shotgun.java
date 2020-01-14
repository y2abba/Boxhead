import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Fires three bullets at once.
 *
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class Shotgun extends Weapon
{
    public Shotgun() {
        super("Shotgun", 300);
        setFireRate(15);
        setDamage(20);
        setBulletSpeed(20);
        setSoundFileName("shotgun.wav");
    }

    @Override
    public void fire() {
        if(fireRateCount == 0) {
            if(ammo > 0) {
                int ymod = 0;
                int xmod = 0;
                if(getHolder().getDirection().equals("up") || getHolder().getDirection().equals("down")) {
                    xmod = 15;
                }else if(getHolder().getDirection().equals("left") ||
                getHolder().getDirection().equals("right")) {
                    ymod = 15;
                }
                Bullet bullet = new Bullet(getHolder().getDirection(), getHolder());
                bullet.setDamage(getDamage());
                getWorld().addObject(bullet, getHolder().getX(), getHolder().getY());
                Bullet bullet2 = new Bullet(getHolder().getDirection(), getHolder());
                bullet2.setDamage(getDamage());
                getWorld().addObject(bullet2, getHolder().getX() + xmod, getHolder().getY() + ymod);
                Bullet bullet3 = new Bullet(getHolder().getDirection(), getHolder());
                bullet3.setDamage(getDamage());
                getWorld().addObject(bullet3, getHolder().getX() - xmod, getHolder().getY() - ymod);
                fireRateCount = fireRate;
                ammo--;
                Greenfoot.playSound(soundFile);
            }
        }
    }
}