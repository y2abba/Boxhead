import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * The scoreboard and highscore system both rely on this class, which passes values to the scoreboard and
 * updates the presented value in game, realtime with the act method.
 * 
 * @author Yameen Abba, Stanley Chan
 * @version (a version number or a date)
 */
public class ScoreManager extends Actor
{
    //Value is used as a counter.
    private int value = 0;
    private int score = 0;
    private int zombiesKilled = 0;
    private int level = 1;
    
    private MyWorld world;
    
    private UIRenderer renderer;
    
    public ScoreManager(MyWorld world) {
        this.world = world;
        renderer = new UIRenderer();
        
        makeImage();
    }
    
    public void act() 
    {
        if(value < score) {
            value++;
            makeImage();
        }else if(value > score) {
            value--;
            makeImage();
        }
    }   
    
    public static boolean containsName(String playername) {
        for(PlayerScore s : Scores.array) {
            System.out.println(s.getName());
            if(s.getName().equals(playername)) return true;
        }
        return false;
    }
    
    /**
     * Adds the score with the player name to the arraylist that is stored in the Scores class.
     */
    public static void addToScoreboard(String playername, int score) {
        PlayerScore player = new PlayerScore(playername, score);
        Scores.array.add(player);
        if(Scores.array.size() > 10) {
            Scores.array.remove(Scores.array.size());
        }
    }
    
    /**
     * Adds to the score
     */
    public void upTheScore(int value)
    {
        if(value == 1)
        {
            score += 100;
            zombiesKilled++;
        }
    }
    
    /**
     * Sets the score to a number
     */
    public void setScore(int set) {
        score = set;
    }
    
    /**
     * Returns the current score
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Returns the counter value
     */
    public int getCounterValue() {
        return value;
    }
    
    public void addLevel(int modifier) {
        level += modifier;
    }
    
    public void makeImage() 
    {
        setImage(new GreenfootImage(""+ score, 24, Color.YELLOW, null));
    }
}
