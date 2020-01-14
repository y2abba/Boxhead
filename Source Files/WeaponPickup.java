import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Allows the pickup of weapons/items, animation related.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class WeaponPickup extends Actor
{
    String weaponPickup = "";
    
    UIRenderer renderer;
    
    int delay = 0;
    
    public WeaponPickup() {
        renderer = new UIRenderer();
    }
    
    public void setText(String str) {
        weaponPickup = str;
        delay = 100;
    }
    
    /**
     * Act - do whatever the WeaponPickup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(delay > 0) {
            getImage().setTransparency(100);
            makeImage();
            delay--;
        }else{
            getImage().setTransparency(0);
        }
    }    
    
    public void makeImage() {
        World world = getWorld();
        world.setPaintOrder(WeaponPickup.class);
        GreenfootImage image = new GreenfootImage(world.getWidth(), world.getHeight());
        Font font = new Font("Arial", false, false, 18);
        image.setFont(font);
        image.setColor(Color.WHITE);
        renderer.drawShadowString(image, "" + weaponPickup, world.getWidth() / 2 - 375, 30);
        setImage(image);
    }
}


