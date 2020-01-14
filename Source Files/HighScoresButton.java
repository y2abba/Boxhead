import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Multiplayer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HighScoresButton extends Button
{
    public HighScoresButton() {
        super("highscorebutton.png");
    }

    public void onClick() {
        Greenfoot.setWorld(new HighScores());
    }
}