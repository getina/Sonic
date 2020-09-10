import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Template for the final ring object
 * 
 * @author Tina Ge 
 * @January 2019 
 */
public class FinalRing extends Actor
{
    private int xValue;
    private int yValue;
    
    public FinalRing(int x, int y)
    {
        xValue = x;
        yValue = y;
        getImage().scale(40, 40);
    }
    
    public void moveRingY(int dy)
    {
        setLocation(getX(), yValue -= dy);
    }
    
    public void moveRingX(int dx)
    {
        setLocation(getX() - dx, yValue);
    } 
}
