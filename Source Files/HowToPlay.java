import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays an image to show how to play this game.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class HowToPlay extends World
{

    UIRenderer renderer;
    
    /**
     * Constructor for objects of class HowToPlay.
     * 
     */
    public HowToPlay()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 825, 1); 
        renderer = new UIRenderer();
        prepare();
    }
    
    public void act() {
        String key = Greenfoot.getKey();
        if("escape".equals(key)) {
            Greenfoot.setWorld(new MainMenu());
        }
    }
    
    public void prepare() {
        GreenfootImage image = new GreenfootImage("howtoplay.png");
        
        Font font = new Font("Arial", false, false, 36);
        image.setFont(font);
        image.setColor(Color.WHITE);
        
        setBackground(image);
    }
}
