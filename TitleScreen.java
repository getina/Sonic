import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates the title screen
 * 
 * @author Tina Ge
 * @version January 2019
 */
public class TitleScreen extends World
{
    private GreenfootSound titleScreenMusic;
    private static Label play;
    
    /**
     * Creates the labels in the tile screen
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        titleScreenMusic = new GreenfootSound("Sonic title screen.wav");
        titleScreenMusic.playLoop();
        
        Label title = new Label("SONIC", 80);
        title.setFillColor(Color.BLUE);
        addObject(title, getWidth()/2, getHeight()/2 - 50);
        
        String instructions = "Use Right Arrow key and space bar \n Grab rings for points \n Make sure to jump on barrels!";
        Label subTitle = new Label(instructions, 25);
        subTitle.setFillColor(Color.BLACK);
        addObject(subTitle, getWidth()/2, getHeight()/2 + 40);

        play = new Label("Click <here> to Begin", 35);
        play.setFillColor(Color.BLUE);
        addObject(play, getWidth()/2, getHeight()/2 + 120);
    }
    
    public void act()
    {
        // Create the game world when user clicks on the title screen
        titleScreenMusic.play();
        titleScreenMusic.playLoop();
        if(Greenfoot.mouseClicked(play)) {
            titleScreenMusic.stop();
            Greenfoot.setWorld(new Mario());
        }
    }
}
