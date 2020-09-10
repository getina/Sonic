import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instantiates the small platform object
 * 
 * @author Tina Ge 
 * @January 2019 
 */
public class SmallPlatform extends Platforms
{ 
    public SmallPlatform(int a, int b)
    {
        getImage().scale(65, 10);
        
        super.x = a;
        super.y = b;
        
        super.object = getImage();
        super.object.setTransparency(0);
    } 
}
