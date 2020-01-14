import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This class governs/ is the bullets that are shot out of the player's guns.
 *
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    String direction = "up";
    Player player;
    private int speed = 10;
    private int damage = 5;
    //Class takes the parameters direction (to face towards), and the player that it is shot from.
    public Bullet(String direction, Player player) {
        this.direction = direction;
        this.player = player;
        setImage(new GreenfootImage("bullet.png"));
    }
    
    //Declares the damage of the bullet.
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    //Returns the damage of the bullet.
    public int getDamage() {
        return damage;
    }

    //Sets the speed of the bullet.
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //Returns the player that shot the bullet.
    public Player getPlayerShot() {
        return player;
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public final void act()
    {
        switch(direction) {
            case "up":
            setLocation(getX(), getY() - speed);
            break;
            case "down":
            setLocation(getX(), getY() + speed);
            break;
            case "left":
            setLocation(getX() - speed, getY());

            break;
            case "right":
            setLocation(getX() + speed, getY());
            break;
        }
        if(getX() >= getWorld().getWidth() - 10 || getX() < 5 || getY() < 5 || getY() >=
        getWorld().getHeight() - 10) {
            getWorld().removeObject(this);
        }
        if(getWorld() != null) {
            Actor zombie = getOneIntersectingObject(Zombie.class);
            if(zombie != null) {
                onZombieHit();
            }
        }
        if(getWorld() != null) {
            Actor actor = getOneIntersectingObject(Platform.class);
            if(actor != null) {
                onWallHit();
            }
        }
    }
    
    //Removes object when it hits a wall.
    public void onWallHit() {
        getWorld().removeObject(this);
    }
    
    //Removes object when it hits a zombie.
    public void onZombieHit() {
        Zombie zombie = (Zombie) getOneIntersectingObject(Zombie.class);
        zombie.damageZombie(getDamage());
        getWorld().removeObject(this);
    }
}