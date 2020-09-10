import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Template for Sonic and determines how he reacts with his environment
 * 
 * @author Tina Ge 
 * @January 2019 
 */
public class TestScroller extends Actor
{
    //physics
    private int velocity = 1;
    private final int GRAVITY = 1;
    
    // variables dependant on the main charcter
    private int groundHeight, sideWidth;
    private static boolean onPlatform = false;
    
    //gameplay
    static int scrolledY = 0; static int points = 0;
    private GreenfootSound jumpSound = new GreenfootSound("Jump.wav");

    /**
     * Instantiates some variables regarding Sonic's character
     */
    public TestScroller()
    {
        getImage().scale(50, 40);
        GreenfootImage sonic = getImage();
        groundHeight = getImage().getHeight()/2;
        sideWidth = getImage().getWidth()/2;
    }
    
    /**
     * Calls on methods that control Sonic. Also determines if Sonic is touching any other object
     * and responds accordingly
     */
    public void act() 
    {
        if(onPlatform == false) fall();        
        getCommand();
        
        if(isTouching(Coins.class)){
            Actor grabCoin = getOneIntersectingObject(Coins.class);
            removeTouching(Coins.class);
  
            GreenfootSound ringSound = new GreenfootSound("Ring.wav");
            ringSound.setVolume(80);
            ringSound.play();
            
            Coins.coinsList.remove(grabCoin);
            
            //add to score
            points++;
            Mario.scoreLabel.setValue("RINGS: " + points);
        }
        
        if(isTouching(Boosts.class)){
            Actor grabBoost = getOneIntersectingObject(Boosts.class);
            removeTouching(Boosts.class);
            extraJump();
            
            GreenfootSound boostSound= new GreenfootSound("Boing.wav");
            boostSound.setVolume(80);
            boostSound.play();
            
            //removes current boost from its array list
            Iterator itr = Boosts.boostsList.iterator();   
            if(itr.hasNext())
            {
                 itr.next();
                 itr.remove();
            }
        } 
        
        isInWorld();
        
        if(isTouching(FinalRing.class)){
            removeTouching(FinalRing.class);
            MyWorld mySky = (MyWorld)getWorld();
            mySky.endScreen(true);
        }
    }
    
    /**
     * Checks if Sonic is in the world, and if he isn't, will call on the end screen method
     */
    public void isInWorld()
    {
        MyWorld mySky = (MyWorld)getWorld();
        if(getY() > 380) mySky.endScreen(false);
    }
    
    /**
     * Checks if player pressed any keys 
     */
    public void getCommand()
    {
        if(Greenfoot.isKeyDown("right") && checkRightWall() == false){
            setLocationWithScroll((getX() + 2), getY());
            isOnPlatform();
        }
        
        if(Greenfoot.isKeyDown("left")){
            setLocationWithScroll((getX() - 2), getY());    
            isOnPlatform();
        }
        
        if(scrolledY >= 0 && Greenfoot.isKeyDown("down")){
            setLocationWithScroll(getX(), getY() + 1, false); 
            scrolledY--;
        }
        
        if(onPlatform == true && Greenfoot.isKeyDown("space")) jump();  
    }
    
    /**
     * Moves the display of the map and all corresponding objects left/right/up/down 
     */
    public void setLocationWithScroll(int newX, int newY, boolean moveCharacters)
    { 
        MyWorld mySky = (MyWorld)getWorld();
        int yShift = newY - getY();
        int xShift = newX - getX();
        
        mySky.moveYValue(xShift, yShift);
        mySky.moveWorld(xShift, yShift);
    }
    
    /**
     * Moves the display of the map left/right/up/down and all corresponding objects left/right
     */
    public void setLocationWithScroll(int newX, int newY)
    { 
        MyWorld mySky = (MyWorld)getWorld();
        int yShift = newY - getY();
        int xShift = newX - getX();
        mySky.moveWorld(xShift, yShift);
    }
    
    /**
     * Sets Sonic's velocity value when player pressed down the spacebar 
     */
    public void jump()
    {
        //restarts soundFX
        jumpSound.stop();
        jumpSound.setVolume(80);
        jumpSound.play();
        
        onPlatform = false;
        velocity = -75;
    }
    
    /**
     * Sets Sonic's velocity value when he touches a boost
     */
    public void extraJump()
    {
       onPlatform = false;
       velocity = -120;
    }
    
    /**
     * Checks to see if Sonic is on a platform. If he is, he will stay on the platform and if he isn't,
     * he will keep on falling
     */
    public void isOnPlatform(){
        onPlatform = false;
        Actor platformBelow = getOneObjectAtOffset(0, 20, Platforms.class);
        
        if(platformBelow != null){        
            onPlatform = true;
            velocity = 0;
            GreenfootImage img = platformBelow.getImage();
            setLocation(getX(), platformBelow.getY() - img.getHeight()/2 - groundHeight);
        }else velocity = 1;
    }
    
    /**
     * Checks to see if Sonic bumped his head on a platform while jumping. If he is, he will fall, if
     * he isn't he will follow through with his jump
     */
    public boolean didBumpHead()
    {
        boolean bumped = false;         
        Actor platformAbove = getOneObjectAtOffset(0, -(groundHeight + 9), Platforms.class);  
        if(platformAbove != null){
            bumped = true;
            GreenfootImage img = platformAbove.getImage();
            setLocation(getX(), platformAbove.getY() + img.getHeight()/2 + groundHeight);
        }
        
        return bumped;
    }
    
    /**
     * Returns if there is a wall to Sonic's right
     */
    public boolean checkRightWall()
    {
        boolean blockingWall = false;
        Actor platformToRight = getOneObjectAtOffset(sideWidth-5, 0, Platforms.class);
        if(platformToRight != null) blockingWall = true;
        return blockingWall;
    }
    
    /**
     * Sets Sonic's location depending on whether he is jumping or falling
     */
    public void fall()
    {       
        boolean continueFalling = false;
      
        if(velocity < 0)
        {
            for(int i = velocity - 1; i < 0; i++){
               moveSonicY(1);
               setLocationWithScroll(getX(), getY() - 1, true);       
               scrolledY++;
               
               if(didBumpHead()){
                   i = velocity;
                   velocity = 0;
               }              
               continueFalling = true;
            }
        }
             
        if(continueFalling || velocity > 0)
        {
            velocity += GRAVITY;
            moveSonicY(-velocity);
            
            if(scrolledY >= 0){
                setLocationWithScroll(getX(), getY() + velocity, false);     
                scrolledY -= velocity;
            }
            isOnPlatform();            
        }
    }
    
    public void moveSonicY(int dy)
    {
        setLocation(getX(), getY() - dy);
    }
}