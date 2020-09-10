import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instantiates the big platform object
 * 
 * @author Tina Ge 
 * @January 2019 
 */
public class Platform extends Platforms
{
    public Platform(int a, int b)
    {
        getImage().scale(300, 10);
        
        super.x = a;
        super.y = b;
        
        super.object = getImage();
        super.object.setTransparency(0);
    }
}