import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This is the spawner that is responsible for maintaining the rate of the zombie spawn, and spawning them.
 * It is transparent and lies 'along' the walls.
 *
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    
    private int spawningTime = 100;
    private int spawningTimeDef = spawningTime;
    public void setSpawningTime(int time) {
        spawningTime = time;
        spawningTimeDef = time;
    }
    
    public Spawner() {
        getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(spawningTime > 0) spawningTime--;
        else{
            spawningTime = spawningTimeDef;
            MyWorld world = (MyWorld) getWorld();
            world.spawnZombie(new Zombie(), getX(), getY());
        }
    }
}