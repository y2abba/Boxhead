import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World displayed after dying.
 * 
 * @author Kelvin Mo 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    UIRenderer renderer;
    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 825, 1); 
        renderer = new UIRenderer();
        prepare();
    }
    
    public void prepare() {
        GreenfootImage image = new GreenfootImage("gameovers.png");
        renderer.drawShadowString(image, "Press escape to continue", 10, getHeight() - 20);
        setBackground(image);
    }
    
    public void act() {
        String key = Greenfoot.getKey();
        if("escape".equals(key)) {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
