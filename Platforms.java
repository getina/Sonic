import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Template for the platform object
 * 
 * @author Tina Ge 
 * @January 2019 
 */
public class Platforms extends Actor
{
    int x;
    int y;
    GreenfootImage object;
    
    public Platforms()
    {       
         Mario.list.add(this);
    }
    
    /**
     * Detremines if this instance of platform is in the world and if so, if it needs to be removed 
     * (when it goes off the screen to reduce memory)
     */
    public boolean platformNeedsRemoving()
    {
        if(Mario.mainCharacter.getWorld() != null && x < (Mario.mainCharacter.getX() - 900)) return true;
        else return false;
    }
    
    public int getWidth()
    {
        return object.getWidth();
    }
    
    public int getHeight()
    {
        return object.getHeight();
    }
    
    /**
     * Returns the platform's x value relative to the map
     */
    public int getConceptualX()
    {
        return x;
    }
    
    /**
     * Returns the platform's y value relative to the map
     */
    public int getConceptualY()
    {
        return y;
    }
    
    public void movePlatformY(int dy)
    {
        y -= dy;
    }
    
    public void movePlatformX(int dx)
    {
        x -= dx; 
        setLocation(x, y);
    } 
}