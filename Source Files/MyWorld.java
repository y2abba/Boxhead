import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * This is the world where the game happens. It takes the parameter of mode/level, whether it is single or 
 * multiplayer. It contains all necessary methods for allowing the Boxhead game to work.
 *
 * @author Stanley Chan, Kelvin Mo, Yameen Abba
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int zombieCount = 0;
    private int maxCount = 10;

    public static ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
    ScoreManager s;
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld(boolean singleplayer)
    {
        super(1050, 825, 1);
        
        s = new ScoreManager(this);
        addObject(s, getWidth()/2, 30);
        GreenfootImage image = new GreenfootImage("howto.png");
        setBackground(image);
        
        Player player = new Player();
        player.setActionKeys("w", "s", "a", "d", "space", "q", "e");
        addObject(new Health(player), 0, 0);
        addObject(player, getWidth() / 2, getHeight() / 2);
        player.setup(1);
        
        if(!singleplayer) {
            Player player2 = new Player();
            player2.setActionKeys("up", "down", "left", "right", ".", ",", "/");
            addObject(new Health(player2), 0, 0);
            addObject(player2, getWidth() / 2 + 50, getHeight() /2);
            player2.setup(2);
            maxCount = 20;
        }
        
        weaponList.add(new MachineGun());
        weaponList.add(new Shotgun());
        weaponList.add(new Pistol());
        weaponList.add(new RocketLauncher());
        weaponList.add(new HealthUp());
    }
    
    public void act() {
        if(getObjects(Player.class).size() <= 0)
        {
            die();
        }
    }
    
    
    // Returns the score manager
    public ScoreManager getScoreManager() {
        return s;
    }
    // Change the world when the players die.
    public void die()
    {
        Greenfoot.setWorld(new EnterName(getScoreManager().getScore()));
    }
    
    // Ups the score by the given value.
    public void upScore(int value)
    {
        s.upTheScore(value);
        if(s.getScore() % 400 == 0) {
            maxCount += 2;
        }
    }

    // Spawns a zombie at the x and y location
    public void spawnZombie(Zombie zombie, int x, int y) {
        if(zombieCount < maxCount) {
            addObject(zombie, x, y);
            zombieCount++;
        }
    }

    // Spawns a box with a weapon in it at the x and y location.
    public void spawnBox(Weapon weapon, int x, int y) {
        Box box = new Box(weapon);
        addObject(box, x, y);
    }
    
    //This method kills the zombies, and after every 10 dead zombies, the max zombie count goes up by 1.
    public void killZombie(Zombie zombie) {
        Random random = new Random();
        int j = random.nextInt(9);
        if(j <= 3) {
            int i = random.nextInt(weaponList.size());
            Weapon weapon = weaponList.get(i);
            spawnBox(weapon, zombie.getX(), zombie.getY());
        }
        if(s.getScore() % 1000 == 0) maxCount++;
        removeObject(zombie);
        zombieCount--;
    }
}


