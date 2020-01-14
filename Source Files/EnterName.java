import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This world class is used to enter and input the name of the player(s) after dying, 
 * in order to record their score.
 * 
 * @author Yameen Abba, Stanley Chan
 * @version (a version number or a date)
 */
public class EnterName extends World
{

    private String name = "";
    private int score;
    
    private int wordDelay = 200;
    private int wordDelayDef = 200;
    
    UIRenderer renderer = new UIRenderer();
    
    GreenfootImage image;
    
    private int wordsKilled = 0;
    
    /**
     * Constructor for objects of class EnterName.
     */
    public EnterName(int score)
    {
        super(1050, 825, 1); 
        this.score = score;
        
        
        GreenfootImage b = new GreenfootImage("highscoreb.png");
        setBackground(b);
        addObject(new EnterNameImage(), getWidth()/2, 100);
        
        image = b;
        image.setFont(new Font("Arial", false, false, 20));
        renderer.drawShadowString(image, "Score: " + score, getWidth()/2 - 35, 200);
        
        makeImage();
    }
    
    //Method creates image that updates every act method.
    public void makeImage() {
        image = new GreenfootImage("highscoreb.png");
        
        image.setFont(new Font("Arial", false, false, 50));
        image.setColor(Color.WHITE);
        image.setFont(new Font("Arial", false, false, 25));
        renderer.drawShadowString(image, name, 25, getHeight() - 50);
        setBackground(image);
    }
    
    public void act() {
        String key = Greenfoot.getKey();
        if(key != null) {
            if(!key.equals("enter") && name.length() < 20 && key.length() == 1) {
                name += key.charAt(0);
                makeImage();
            }else if(key.equals("enter") && name.length() > 0){
                if(!ScoreManager.containsName(name)) {
                    ScoreManager.addToScoreboard(name, score);
                    Greenfoot.setWorld(new GameOver());
                }else{
                    renderer.drawShadowString(image, "Name already taken", 3, 300);
                }
            }else if(Greenfoot.isKeyDown("backspace") && name.length() > 0) {
                name = name.substring(0, name.length() - 1);
                makeImage();
            }
        }
    }
}