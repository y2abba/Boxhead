import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This world class is used to set the level and pass a boolean value to the world class to setup
 * the game based on whether it is multiplayer or singleplayer. These are the two 'levels'.
 * 
 * @author Kelvin Mo
 * @version (a version number or a date)
 */
public class Level extends MyWorld
{
    String[] map;
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level(boolean singleplayer)
    {
        super(singleplayer);
        setFields();
        for(int i = 0; i<map.length;i++)
        {
            for(int j =0; j < map[i].length();j++)
            {
                int kind = "wsbi".indexOf(""+map[i].charAt(j));
                if(kind < 0) continue;
                Actor player = null;
                if(kind == 0) player = new Platform(false);
                if(kind == 1) player = new Spawner();
                if(kind == 2) player = new Box();
                if(kind == 3) player = new Platform(true);
                addObject(player, j*25, i*25);
            }
        }
    }
    
    public void setFields(){}
}


