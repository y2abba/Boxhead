import greenfoot.*;

/**
 * User interface renderer.
 * 
 * @author Stanley Chan 
 * @version (a version number or a date)
 */
public class UIRenderer  
{

    /**
     * Constructor for objects of class UIRenderer
     */
    public UIRenderer()
    {
    }
    
    public void drawShadowString(GreenfootImage img, String string, int x, int y) {
        img.setColor(Color.BLACK);
        img.drawString(string, x+2, y+2);
        img.setColor(Color.WHITE);
        img.drawString(string, x, y);
    }
    
    public void drawRect(GreenfootImage img, int x, int y, int width, int height, Color color) {
        img.setColor(color);
        img.fillRect(x, y, width, height);
    }
}


