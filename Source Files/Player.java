import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * This is the Player class, it contains the move methods, methods preventing it from moving into walls,
 * methods to shoot, and many more. The basis of the game and the player management are contained in here.
 * Player 1 and 2 are not created in seperate classes, rather they use the same class, but are contained in
 * different objects. As such, parameters governing player numbe exist.
 *
 * @author Stanley Chan, Yameen Abba, Kelvin Mo
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    //Keys that are used to 
    private String up, left, down, right, fire, switchLeft, switchRight;
    private String direction;
    //Weapon that the player is holding.
    private Weapon curWeapon;
    //Health variable.
    private int health = 100;
    private ArrayList<Weapon> inventory;
    WeaponPickup wp;
    //Player numer.
    private int playerNumber;
    
    int speed = 5;
    
    public Player() {
        direction = "right";
        inventory = new ArrayList<Weapon>();
        wp = new WeaponPickup();
    }
    
    int switchDelay = 10;
    /**
     * Act - do whatever the Player wants to do. This method is
    called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        GreenfootImage image = new GreenfootImage(curWeapon.getName().toLowerCase() + "_right.png");
        image.scale(image.getWidth() / 4, image.getHeight() / 4);
        getWorld().setPaintOrder(Player.class);
        setImage(image);
        checkHit();
        keyCheck();
        if(speedCount > 0) speedCount--;
        else{
            speed = 5;
        }
    }
    
    // Returns the player's health.
    public int getHealth() {
        return health;
    }
    
    // Setups the player.
    public void setup(int player) {
        curWeapon = new Pistol();

        curWeapon.setHolder(this);
        getWorld().addObject(curWeapon, 0, 0);
        inventory.add(curWeapon);
        if(player == 1) {
            getWorld().addObject(wp, getWorld().getWidth() / 2, getWorld().getHeight());
        }else{
            getWorld().addObject(wp, getWorld().getWidth(), getWorld().getHeight());
        }
        playerNumber = player;
    }
    
    // Returns the player's number.
    public int getPlayerNumber() {
        return playerNumber;
    }

    // Returns the player's weapon in hand
    public Weapon getPlayerWeapon() {
        return curWeapon;
    }

    // Checks if the player has a weapon.
    public boolean hasWeapon(Weapon weapon) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName() == weapon.getName())
                return true;
        }
        return false;
    }

    // Adds a weapon to the player's inventory.
    public void addWeapon(Weapon weapon) {
        wp.setText("Picked up " + weapon.getName());
        if(hasWeapon(weapon)) {
            for(int i = 0; i < inventory.size(); i++) {
                if(inventory.get(i).getName() == weapon.getName()) {
                    inventory.get(i).refillAmmo();
                }
            }
            return;
        }
        weapon.setHolder(this);
        getWorld().removeObject(curWeapon);
        curWeapon = weapon;
        getWorld().addObject(curWeapon, 0, 0);
        inventory.add(weapon);
    }
    
    /**
     * Sets action keys based on given parameters, allows the verstatility of having only one class for
     * two players.
     */
    public void setActionKeys(String up, String down, String left,
    String right, String fire, String switchLeft, String switchRight) {
        this.up = up;
        this.left = left;
        this.down = down;
        this.right = right;
        this.fire = fire;
        this.switchLeft = switchLeft;
        this.switchRight = switchRight;
    }

    public void die() {
        getWorld().removeObject(this);
    }
    
    //This method checks the keys, and allows movement if the path of movement is clear.
    public void keyCheck()
    {
        if(Greenfoot.isKeyDown(up)) {
            setRotation(270);
            if(checkAbove()) {
                move(speed);
                direction = "up";
            }
        }
        if(Greenfoot.isKeyDown(left)) {
            setRotation(180);
            if(checkLeft()) {
                move(speed);
                direction = "left";

            }
        }
        if(Greenfoot.isKeyDown(right)) {
            setRotation(0);
            if(checkRight()) {
                move(speed);
                direction = "right";
            }
        }
        if(Greenfoot.isKeyDown(down)) {
            setRotation(90);
            if(checkBelow()) {
                move(speed);
                direction = "down";
            }
        }
        if(Greenfoot.isKeyDown(fire)) {
            fire(direction);
        }
        if(switchDelay == 0) {
            if(Greenfoot.isKeyDown(switchLeft)) {
                switchWeapon(switchLeft);

                switchDelay = 10;
            }
            if(Greenfoot.isKeyDown(switchRight)) {
                switchWeapon(switchRight);
                switchDelay = 10;
            }
        }
        if(switchDelay > 0) {
            switchDelay--;
        }
    }

    int invincibility = 0;
    
    //Checks to see if zombies are hitting the player, if so, lose health based on bullet type.
    public void checkHit()
    {
        if(invincibility > 0) invincibility--;
        Actor bullet = getOneIntersectingObject(Bullet.class);
        if(bullet != null){
            Bullet shot = (Bullet) bullet;
            if(shot.getPlayerShot() != this) {
                getWorld().removeObject(shot);
                if(shot instanceof Rocket) {
                    damagePlayer(25);
                }else{
                    damagePlayer(5);
                }
            }
        }
        Actor zombie = getOneIntersectingObject(Zombie.class);
        if(invincibility == 0) {
           if(zombie != null) {
               damagePlayer(5);
               invincibility = 20;
           }else{
               getImage().setTransparency(255);
           }   
        }
        if(health <= 0) {
            die();
        }
    }
    
    private int speedCount = 0;
    
    public void damagePlayer(int damage) {
        health -= damage;
        speedCount = 5;
        speed = 1;
        getImage().setTransparency(220);
    }

    //Switches weapon based on direction - switchLeft or switchRight - inventory style.
    public void switchWeapon(String direction) {
        if(direction == switchLeft) {
            int i = inventory.indexOf(curWeapon);
            if(i == 0) return;
            getWorld().removeObject(curWeapon);
            curWeapon = inventory.get(i - 1);
            curWeapon.setHolder(this);
            getWorld().addObject(curWeapon, 0, 0);
        }else if(direction == switchRight) {
            int i = inventory.indexOf(curWeapon);
            if(i == inventory.size() - 1) return;
            getWorld().removeObject(curWeapon);
            curWeapon = inventory.get(i + 1);
            curWeapon.setHolder(this);
            getWorld().addObject(curWeapon, 0, 0);
        }
    }

    //Checks to see if block above.
    public boolean checkAbove()
    {
        if(getWorld() == null) return false;
        int playerH = getImage().getHeight();
        int findPlatform = (int) (playerH/-2 + 3);
        Actor topBlock = getOneObjectAtOffset(0, findPlatform, Platform.class);
        if(topBlock != null)
        {
            return false;
        }
        return true;
    }
    
    //Checks to see if block below.
    public boolean checkBelow()
    {
        if(getWorld() == null) return false;
        int playerH = getImage().getHeight();
        int findGround = (int) (playerH/2 + 5);
        Actor Ground = getOneObjectAtOffset(0, findGround, Platform.class);
        if(Ground != null)
        {
            return false;
        }
        return true;
    }
    
    //Checks to see if block to the right.
    public boolean checkRight()
    {
        if(getWorld() == null) return false;
        int playerW = getImage().getWidth();
        int findRight = (int) (playerW/2 - 3);
        Actor rightBlock = getOneObjectAtOffset(findRight, 0, Platform.class);
        if(rightBlock != null)
        {
            return false;
        }
        return true;
    }
    
    //Checks to see if block to the left.
    public boolean checkLeft()
    {
        if(getWorld() == null) return false;
        int playerW = getImage().getWidth();
        int findLeft = (int) (playerW/-2 + 2);
        Actor leftBlock = getOneObjectAtOffset(findLeft, 0, Platform.class);
        if(leftBlock != null)
        {
            return false;
        }
        return true;
    }

    
    public String getDirection() {
        return direction;
    }

    public void fire(String direction) {
        getPlayerWeapon().fire();
    }
    
    public void addHealth(int modifier) {
        health += modifier;
        if(health > 100) health = 100;
    }
    
    public void setWeaponPickupText(String str) {
        wp.setText(str);
    }
}