import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This class governs the usage of weapons in the game, ranging from machines guns to rocket launchers. Each
 * weapon has its different unique qualities, such as increased firerate, multiple bullets at once and/or
 * different type of bullets.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{
    private String weaponName;
    public int fireRate = 10;
    private Player holder;
    public int fireRateCount = 0;
    private int bspeed = 10;
    private int damage = 5;

    public int ammo, defAmmo;

    public String soundFile;

    public Weapon(String weaponName, Player holder, int ammo) {
        this.weaponName = weaponName;
        this.holder = holder;
        this.ammo = ammo;
        this.defAmmo = ammo;
        getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public final void act()
    {
        if(fireRateCount > 0) {
            fireRateCount--;
        }
        if(holder != null && holder.getWorld() != null) {
            setLocation(holder.getX(), holder.getY());
        }
        if(holder.getWorld() == null) getWorld().removeObject(this);
    }

    public void setDamage(int dmg) {
        this.damage = dmg;
    }

    public int getDamage() {
        return damage;
    }

    public void setSoundFileName(String name) {
        soundFile = name;
    }

    public Weapon(String weaponName, int ammo) {
        this.weaponName = weaponName;
        this.ammo = ammo;
        this.defAmmo = ammo;
    }

    public void setHolder(Player holder) {
        this.holder = holder;
    }

    public Player getHolder() {
        return holder;
    }

    public String getName() {
        return weaponName;
    }

    public void setFireRate(int rate) {
        this.fireRate = rate;
    }

    public void setBulletSpeed(int speed) {
        this.bspeed = speed;
    }

    public void fire() {
        if(fireRateCount == 0) {
            if(ammo != 0) {
                Bullet bullet = new Bullet(holder.getDirection(), holder);
                bullet.setSpeed(bspeed);
                bullet.setDamage(damage);
                checkBulletExit(bullet);
                fireRateCount = fireRate;
                ammo--;
                Greenfoot.playSound(soundFile);
            }
        }
    }

    public void checkBulletExit(Bullet bullet) {
        if(holder != null)
        {
            switch(holder.getDirection()){
                case "right":
                getWorld().addObject(bullet, holder.getX(), holder.getY() + 15);
                case "left":
                getWorld().addObject(bullet, holder.getX(), holder.getY() - 15);
                case "up":
                getWorld().addObject(bullet, holder.getX() + 15, holder.getY());
                case "down":
                getWorld().addObject(bullet, holder.getX() - 15, holder.getY());
            }
        }
    }

    public void refillAmmo() {
        ammo = defAmmo;
    }

    public int getAmmo() {
        return ammo;
    }

    public String getAmmoString() {
        if(getName().equalsIgnoreCase("pistol")) return "infinite";
        return ammo + "";
    }
}