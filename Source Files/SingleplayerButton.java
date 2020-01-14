import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Singleplayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SingleplayerButton extends Button
{
    public SingleplayerButton() {
        super("singleplayerbutton.png");
    }

    public void onClick() {
        Greenfoot.setWorld(new Terrain(true));
    }
}