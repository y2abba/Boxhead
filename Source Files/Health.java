import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class governs/is the health of the player.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    private Player player;
    
    public Health(Player p) {
        this.player = p;
    }
    
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(player.getWorld() != null) {
            updateString();
            setLocation(player.getX(), player.getY() - 70);
        }else{
            getWorld().removeObject(this);
        }
    }    
    
    public void updateString() {
        getWorld().setPaintOrder(Health.class);
        GreenfootImage image = new GreenfootImage("HP: " + player.getHealth() + "\n" + player.getPlayerWeapon().getName() + ": " + player.getPlayerWeapon().getAmmoString() + "\nPlayer: " + player.getPlayerNumber(), 20, Color.WHITE, Color.BLACK);
        image.setTransparency(200);
        setImage(image);
    }
}
