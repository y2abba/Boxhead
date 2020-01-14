import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Restores player's health.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class HealthUp extends Item
{
    public HealthUp() {
        super("Health");
    }
    
    public void pickupAction(Player player) {
        player.addHealth(30);
        player.setWeaponPickupText("Picked up " + getItemName());
    }
}
