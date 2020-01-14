import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class creates the platforms that are in the map.
 * 
 * @author Kelvin Mo 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    private boolean isInvisible;
    
    public Platform(boolean invisible) {
        this.isInvisible = invisible;
        if(invisible) {
            getImage().setTransparency(0);
        }
    }
    
    public boolean isInvisible() { return isInvisible; }
}
