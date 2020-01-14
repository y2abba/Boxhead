import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the main menu of the game. Start here.
 * 
 * @author Stanley Chan
 * @version (a version number or a date)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1050, 825, 1); 
        prepare();
    }
    
    private void prepare() {
        Logo logo = new Logo();
        addObject(logo, getWidth() / 2, 200);
        
        GreenfootImage image = new GreenfootImage("howto.png");
        image.setColor(Color.RED);
        image.setFont(new Font("Arial", false, false, 24));
        image.drawString("Beta Version!", 4, getHeight() - 15);
        
        setBackground(image);
        
        PlayButton play = new PlayButton();
        addObject(play, getWidth() / 2, getHeight() / 2);
        
        HowToButton htb = new HowToButton();
        addObject(htb, getWidth() / 2, getHeight() / 2 + 120);
        
        HighScoresButton hsb = new HighScoresButton();
        addObject(hsb, getWidth() / 2, getHeight() / 2 + 240);
    }
}
