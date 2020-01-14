import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * The Rocket class is used to shoot rockets that cause area of effect damage to zombies. A special type of
 * bullet, with inheritance from the bullet class.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class Rocket extends Bullet
{
    //The rocket class inherits the properties of a basic bullet.
    public Rocket(String direction, Player player) {
        super(direction, player);
    }  
    
    //Overrides the super class method to remove when hitting a wall.
    @Override
    public void onWallHit() {
        List<Player> nearPlayers = getObjectsInRange(100, Player.class);
        List<Zombie> nearZombies = getObjectsInRange(175, Zombie.class);
        for(Player p : nearPlayers) {
            p.damagePlayer(25);
        }
        
        for(Zombie z : nearZombies) {
            z.damageZombie(50);
        }
        Explosion explosion = new Explosion();
        getWorld().addObject(explosion, getX(), getY());
        getWorld().removeObject(this);
    }
    
    //Overrides the super class method to remove when hitting a zombie.
    @Override
    public void onZombieHit() {
        onWallHit();
    }
}
