import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Creates the scrolling world and allows objects to move with it
 * 
 * @author Tina Ge
 * @version January 2019
 */
public class MyWorld extends World
{ 
    //background variables
    private GreenfootImage bg;
    private static int width, height;
    private static int x = 0, y = 0;

    private Label restart = new Label("RESTART", 25); 
    
    // music
    private GreenfootSound bgMusic;
    private GreenfootSound endingMusic;

    /**
     * Creates the section of the map to be shown and adds objects onto the sreen 
     */
    public MyWorld(int width, int height)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1, false); 
        this.width = width;
        this.height = height;
        
        bgMusic = new GreenfootSound("Sonic play.wav");
        bgMusic.playLoop();
        bg = getBackground(); // creates the starting screen display and adjusts the position
        int dy = bg.getHeight() - 2 * height + 90; 
        
        addCoins();
        moveWorld(0, dy);
    }
  
    /**
     * Moves all objects and characters in the screen up/down
     */
    public void moveYValue(int dx, int dy)
    {
        List <Platforms> platformsInPlay =  getObjects(Platforms.class);
        List <Boosts> boostsInPlay =  getObjects(Boosts.class);
        
        for(Platforms platform : platformsInPlay) platform.movePlatformY(dy);
        for(Coins coin : Coins.coinsList) coin.moveCoinY(dy);
        for(Boosts boost : boostsInPlay) boost.moveBoostY(dy);
        
        if(Mario.finalRing != null) Mario.finalRing.moveRingY(dy);
        if(Mario.mainCharacter != null) Mario.mainCharacter.moveSonicY(dy);
    }
    
    /**
     * Determines if objects should be added to the screen and if they're already in it, if they should  
     * move left/right. Also detremines if the world should move left/right
     */
    public void moveWorld(int dx, int dy)
    {
        x += dx;
        y += dy;

        GreenfootImage mask = new GreenfootImage(width, height);
        mask.drawImage(bg, -x, -y);
        setBackground(mask); 

        for(Platforms t : Mario.list){
            int platformHeight = t.getHeight();
            int platformWidth = t.getWidth();
          
            //checking if platform should be in the screen
            if(t.getConceptualX() + platformWidth >= 0 && t.getConceptualX() - platformWidth <= 
            bg.getWidth() && t.getConceptualY() + platformHeight <= bg.getHeight()){  
                 if(t.getWorld() == null) addObject(t, t.getConceptualX(), t.getConceptualY());
                 else t.movePlatformX(dx);  
                 
                 Iterator itr = Mario.list.iterator();
                 while(itr.hasNext()){
                     Platforms checkThePlatform = (Platforms)itr.next();
                     if(checkThePlatform.platformNeedsRemoving()){
                         removeObject(checkThePlatform);      
                         itr.remove();
                     }
                 }
            }
        }
        
        for(Coins coin : Coins.coinsList) coin.moveCoinX(dx); 
        
        for(Boosts boost: Boosts.boostsList){
            addObject(boost, boost.getConceptualX(), boost.getConceptualY());
            boost.moveBoostX(dx); 
        }
        
        if(Mario.finalRing != null) Mario.finalRing.moveRingX(dx);
    }

    /**
     * Adds coins to the world in random locations
     */
    public void addCoins()
    {
        for(int i = 0; i < 20; i++)
        {
            addObject(new Coins(), generateRandomNumber(0, 9000),
            generateRandomNumber(50, 270));
        }
    }
    
    public int generateRandomNumber(int start, int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    
    /**
     * Creates the end game screen (both win and lose)
     */
    public void endScreen(boolean win)
    {
        Greenfoot.stop();
        bgMusic.stop();

        String winOrLose;
        String music;
        
        if(win){
            winOrLose = "Win";
            music = "Win.mp3";
        }else{
            winOrLose = "Game Over!";
            music ="Sonic lose.wav";
        }
        endingMusic = new GreenfootSound(music);
        endingMusic.play();
        
        bg.setTransparency(30);

        Label gameOverLabel = new Label(winOrLose, 100);
        gameOverLabel.setFillColor(Color.RED);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2 - 50);

        // Show the score
        Label scoreLabel = new Label("Final Score: " + (TestScroller.points * 100), 70);
        scoreLabel.setFillColor(Color.RED);
        addObject(scoreLabel, getWidth()/2, getHeight()/2 + 50);

        // Creates the restart button
        restart.setFillColor(Color.BLACK);
        addObject(restart, getWidth()/2, getHeight()/2 + 120);
    }
    
    /**
     * Determines if player pressed restart
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(restart)) {
            endingMusic.stop();
            Greenfoot.setWorld(new Mario());
            
            //resetting values
            TestScroller.points = 0;
            Mario.scoreLabel.setValue("Score: " + 0);
            TestScroller.scrolledY = 0;
        }
    }
}