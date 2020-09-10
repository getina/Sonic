import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Template for the boost object
 * 
 * @author Tina Ge 
 * @January 2019 
 */
public class Boosts extends Actor
{
    private int theX;
    private int theY;
    static ArrayList <Boosts> boostsList = new ArrayList<Boosts>();
    
    public Boosts(int x, int y)
    {
        theX = x;
        theY = y;
        boostsList.add(this);
    }
    
    public void moveBoostX(int dx)
    {
        setLocation(getX() - dx, getY());
    }       
    
    public void moveBoostY(int dy)
    {
        setLocation(getX(), getY() - dy);
    }

    /**
     * Returns the boost's x value relative to the map
     */
    public int getConceptualX()
    {
        return theX;
    }
    
    /**
     * Returns the boost's y value relative to the map
     */
    public int getConceptualY()
    {
        return theY;
    }
}
