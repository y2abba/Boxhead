import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is used as a medium to deliver the structure of how the map should be built in the MyWorld/Level
 * class.
 * 
 * @author Kelvin Mo
 * @version (a version number or a date)
 */
class Terrain extends Level
{           
    public Terrain(boolean singleplayer) {
        super(singleplayer);
    }   
    
    //42 x 32
    public void setFields()
    {
        map = new String[] {"                                         ",
                            " wwwwwwwwwwwwwwwwwwwiiiwwwwwwwwwwwwwwwwwww",
                            " w                   s                   w",
                            " w                                       w",
                            " w     w                           w     w",   
                            " w     w                           w     w",  
                            " w     w                           w     w",  
                            " w                                       w",
                            " w               ww      ww              w",  
                            " w               ww b  b ww              w",
                            " w                                       w",   
                            " w                                       w",
                            " w                                       w",  
                            " w                                       w",
                            " w     w                           w     w",
                            " w     w                           w     w",      
                            " i                                       i",
                            " is                                     si",
                            " i                                       i",
                            " w     w                           w     w",
                            " w     w                           w     w",
                            " w                                       w",
                            " w                                       w",    
                            " w                                       w", 
                            " w               ww b   b ww             w",
                            " w               ww       ww             w",
                            " w   w                               w   w",
                            " w   w                               w   w",
                            " w   w                               w   w",
                            " w                                       w",
                            " w                                       w",
                            " w                   s                   w",
                            " wwwwwwwwwwwwwwwwwwwiiiwwwwwwwwwwwwwwwwwww",};                           
    }
    
    public void nextPage()
    {
        Greenfoot.setWorld(new GameOver());
    }
}


