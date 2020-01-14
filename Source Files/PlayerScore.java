/**
 * Write a description of class PlayerScore here.
 * 
 * @author Yameen Abba
 * @version (a version number or a date)
 */
public class PlayerScore  
{
    private String name;
    private int score;

    /**
     * Constructor for objects of class PlayerScore
     */
    public PlayerScore(String player, int score)
    {
        name = player;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
}
