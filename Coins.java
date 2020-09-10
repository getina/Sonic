import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Template for the coin object
 * 
 * @author Tina Ge 
 * @January 2019 
 */
public class Coins extends Actor
{
    static ArrayList <Coins> coinsList = new ArrayList<Coins>();
    
    public Coins()
    {  
        getImage().scale(40, 40);
        coinsList.add(this);
    }
    
    public void moveCoinX(int dx)
    {
        setLocation(getX() - dx, getY());
    }       
    
    public void moveCoinY(int dy)
    {
        setLocation(getX(), getY() - dy);
    }
}
