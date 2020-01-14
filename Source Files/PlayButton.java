import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Button
{
    public PlayButton() {
        super("PlayButton.png");
    }
    
    public void onClick() {
        Greenfoot.setWorld(new MultiplayerSelect());
    }
}
