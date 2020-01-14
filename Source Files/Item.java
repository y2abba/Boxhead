import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Items that can be picked up in game.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class Item extends Weapon
{
    private String itemName;
    
    public Item(String itemName) {
        super(itemName, 0);
        this.itemName = itemName;
    }
    
    public String getItemName() { return itemName; }
    
    public void pickupAction(Player player) {}
}
