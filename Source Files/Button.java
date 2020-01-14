import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * These are the buttons that are used in the game, and perform actions to change worlds.
 * 
 * @author Steven Lin, Stanley Chan
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public final void act() 
    {
       if(Greenfoot.mouseClicked(this))
        {
            onClick();
        }
    }   
    //Whenever a button is clicked.
    public void onClick() {}
    public Button(String imageName)
    {
        setImage(new GreenfootImage(imageName));
        getImage().scale(getImage().getWidth() / 2, getImage().getHeight() /2);
        getImage().setTransparency(245);
    }   
}