import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This world class is used for the screen where the player(s) select the mode.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiplayerSelect extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MultiplayerSelect()
    {   
        super(1050, 825, 1); 
        prepare();
    }
    
    private void prepare() {
        GreenfootImage image = new GreenfootImage("howto.png");
        
        image.setFont(new Font("Arial", false, false, 40));
        image.setColor(Color.WHITE);
        image.drawString("Press escape to return", 10, getHeight() - 40);
        
        setBackground(image);
        SingleplayerButton sp  = new SingleplayerButton();
        MultiplayerButton mp = new MultiplayerButton();
        addObject(sp, getWidth() / 2, getHeight() / 2);
        addObject(mp, getWidth() / 2, getHeight() / 2 + 120);
        
    }
    
    public void act() {
        String key = Greenfoot.getKey();
        if("escape".equals(key)) {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}
