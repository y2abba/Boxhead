import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * This class is responsible for the zombies in the game. Many methods used here are similar to the Player
 * class, and share methods with other classes too.
 *
 * @author Stanley Chan, Yameen Abba, Kelvin Mo
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    private boolean isDead = false;
    private int health = 0;
    
    private int transparencyCount = 0;
    private int speedCount = 0;
    
    private int zSpeed = 1;
    public Zombie() {
        health = 100;
        setImage(new GreenfootImage("Zombie1.png"));
    }

    /**
     * Act - do whatever the Zombie wants to do. This method is called
    whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(transparencyCount > 0) transparencyCount--;
        else{
            getImage().setTransparency(255);
        }
        if(speedCount > 0) speedCount--;
        else{
            zSpeed = 1;
        }
        checkDeath();
        moveToPlayer(getClosestPlayer());
        Actor bullet = getOneIntersectingObject(Bullet.class);
        if(bullet != null){
            Bullet shot = (Bullet) bullet;
            damageZombie(shot.getDamage());
            getWorld().removeObject(shot);
        }
        die();
    }
    
    public void damageZombie(int damage) {
        health -= damage;
        getImage().setTransparency(100);
        transparencyCount = 50;
        zSpeed = 0;
        speedCount = 10;
    }

    public double getDistanceFromPlayer(Player player) {
        return Math.hypot(player.getX() - getX(), player.getY() - getY());
    }

    public Player getClosestPlayer() {
        List<Player> nearPlayers = getObjectsInRange(1000, Player.class);

        Player nearestPlayer = nearPlayers.get(0);
        double distance;
        double nearestDistance = getDistanceFromPlayer(nearestPlayer);
        for(int i = 0; i < nearPlayers.size(); i++) {
            distance = getDistanceFromPlayer(nearPlayers.get(i));
            if(distance < nearestDistance) {
                nearestPlayer = nearPlayers.get(i);
                nearestDistance = distance;
            }
        }
        return nearestPlayer;
    }

    public void checkDeath()
    {
        if(health <= 0) {
            isDead = true;
        }
    }
    
    public void checkRotation(int deltaX, int deltaY) {
        double playerAngle = Math.toDegrees(Math.atan2((double) deltaX, (double) deltaY)) + 90;
        if(playerAngle < 0) playerAngle += 360;
        if(playerAngle > 0 && playerAngle <= 45) {
            playAnimation("ZombieR");
        }else if(playerAngle > 45 && playerAngle <= 135) {
            playAnimation("ZombieB");
        }else if(playerAngle > 135 && playerAngle <= 225) {
            playAnimation("ZombieL");
        }else if(playerAngle > 225 && playerAngle <= 305) {
            playAnimation("Zombie");
        }else if(playerAngle > 305 && playerAngle <= 359) {
            playAnimation("ZombieR");
        }
    }
    
    int frameCount = 10;
    int curFrame = 1;
    
    public void playAnimation(String filename) {
        if(frameCount > 0) frameCount--;
        else{
            setImage(new GreenfootImage(filename + curFrame + ".png"));
            curFrame++;
            if(curFrame == 4) curFrame = 1;
            frameCount = 10;
        }
    }
    
    public void moveToPlayer(Player player) {
        int deltaX = getX() - player.getX();
        int deltaY = getY() - player.getY();
        checkRotation(deltaX, deltaY);
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            if (deltaX > 0) {
                if(checkLeft()) {
                    setLocation(getX() - zSpeed, getY());
                }
            }
            else if (deltaX < 0) {
                if(checkRight()) {
                    setLocation(getX() + zSpeed, getY());
                }
            }
        }
        else {
            if (deltaY > 0) {
                if(checkAbove()) {
                    setLocation(getX(), getY() - zSpeed);
                }
            }
            else if (deltaY < 0) {
                if(checkBelow()) {
                    setLocation(getX(), getY() + zSpeed);
                }
            }
        }
    }
    
    public boolean checkAbove()
    {
        int playerH = getImage().getHeight();
        int findPlatform = (int) (playerH/-2 + 3);
        Actor topBlock = getOneObjectAtOffset(0, findPlatform, Platform.class);
        Actor player = getOneObjectAtOffset(0, findPlatform, Player.class);
        if(topBlock != null || player != null)
        {
            if(topBlock != null) {
                Platform p = (Platform) topBlock;
                if(p.isInvisible()) return true;
            }
            return false;
        }
        return true;
    }
    
    public boolean checkBelow()
    {
        int playerH = getImage().getHeight();
        int findGround = (int) (playerH/2 + 5);
        Actor Ground = getOneObjectAtOffset(0, findGround, Platform.class);
        Actor player = getOneObjectAtOffset(0, findGround, Player.class);
        if(Ground != null || player != null)
        {
            if(Ground != null) {
                Platform p = (Platform) Ground;
                if(p.isInvisible()) return true;
            }
            return false;
        }
        return true;
    }
    
    public boolean checkRight()
    {
        int playerW = getImage().getWidth();
        int findRight = (int) (playerW/2 - 3);
        Actor rightBlock = getOneObjectAtOffset(findRight, 0, Platform.class);
        Actor player = getOneObjectAtOffset(findRight, 0, Player.class);
        if(rightBlock != null || player != null)
        {
            if(rightBlock != null) {
                Platform p = (Platform) rightBlock;
                if(p.isInvisible()) return true;
            }
            return false;
        }
        return true;
    }
    
    public boolean checkLeft()
    {
        int playerW = getImage().getWidth();
        int findLeft = (int) (playerW/-2 + 2);
        Actor leftBlock = getOneObjectAtOffset(findLeft, 0, Platform.class);
        Actor player = getOneObjectAtOffset(findLeft, 0, Player.class);
        if(leftBlock != null || player != null)
        {
            if(leftBlock != null) {
                Platform p = (Platform) leftBlock;
                if(p.isInvisible()) return true;
            }
            return false;
        }
        return true;
    }
    
    //When dying, the score increases based on the value of the zombie, which is 1.
    public void die()
    {
        if(isDead == true)
        {
            MyWorld world = (MyWorld) getWorld();
            world.upScore(1);
            world.killZombie(this);
        }
    }
}