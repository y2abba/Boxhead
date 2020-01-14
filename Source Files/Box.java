import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * This class is used to create powerups/new guns for the player(s) to use. Player must walk over these boxes
 * to be granted new weapons.
 *
 * @author Kelvin Mo
 * @version (a version number or a date)
 */
public class Box extends Actor
{
    private boolean isDead = false;
    private Weapon weapon;
    //Constructor is declared with a weapon 'inside' of it.
    public Box(Weapon weapon) {
        this.weapon = weapon;
        GreenfootImage image = new GreenfootImage("box.png");
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
    }
    
    //Creates a box with a random item in it.
    public Box() {
        Random r = new Random();
        int i = r.nextInt(MyWorld.weaponList.size());
        this.weapon = MyWorld.weaponList.get(i);
        GreenfootImage image = new GreenfootImage("box.png");
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
    }

    /**
     * Act - do whatever the Box wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        death();
    }

    /**
     * When the player walks over and picks up the box.
     */
    public void death()
    {
        if(getOneIntersectingObject(Player.class) != null)
        {
            Player player = (Player) getOneIntersectingObject(Player.class);
            if(weapon instanceof Item) {
                Item i = (Item) weapon;
                i.pickupAction(player);
            }else{
                player.addWeapon(weapon);
            }
            getWorld().removeObject(this);
        }
    }
}