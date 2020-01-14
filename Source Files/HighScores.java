import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World that is displayed to show the high scores list.
 * 
 * @author Yameen Abba, Stanley Chan
 * @version
 */
public class HighScores extends World
{

    UIRenderer renderer;
    
    private int width, height;
    Scores score = new Scores();
    
    /**
     * Constructor for objects of class HighScores.
     * 
     */
    public HighScores()
    {   
        super(1050, 825, 1);
        renderer = new UIRenderer();
        width = getWidth();
        height = getHeight();
        makeImage();
    }
    
    //Image to be displayed, updates and draws itself based on the arraylist stored in the Scores class.
    public void makeImage() {
        GreenfootImage image = new GreenfootImage("howto.png");
        
        Font font = new Font("Arial", false, false, 20);
        image.setFont(font);
        image.setColor(Color.WHITE);
        renderer.drawShadowString(image, "High Scores", width / 2 - 53, 25);
        renderer.drawShadowString(image, "Press escape to return to menu", 2, getHeight() - 20);
        int x = 0;
        if(score.getScores() != null) {
            for(int i = score.getScores().size() - 1; i > score.getScores().size() - 11 && i > 0; i--) {
                renderer.drawShadowString(image, score.getScores().get(i).getName() + ", " + score.getScores().get(i).getScore(), width / 2 - 53, 100 + x);
                x += 30;
            }
        }
        setBackground(image);
    }
    
    public void act() {
        if("escape".equals(Greenfoot.getKey())) {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}