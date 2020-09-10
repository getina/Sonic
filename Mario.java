import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Prepares the world Sonic will be playing in
 * 
 * @author Tina Ge
 * @version January 2019
 */
public class Mario extends MyWorld
{
    static ArrayList <Platforms> list = new ArrayList<Platforms>();
    static TestScroller mainCharacter;
    
    //  constants 
    private final int i = -368; int a = -667;
    
    static Label scoreLabel;
    static FinalRing finalRing;
    
    /**
     * Creates the world and Sonic
     */
    public Mario()
    {
        //default settings are 600, 350
        super(600, 350);   
        prepare();
        mainCharacter = new TestScroller();
        addObject(mainCharacter,300, 140);
        moveWorld(0,0);
    }
    
    /**
     * Stores all interactive objects to the game but not necessarily adding it to the world yet
     */
    private void prepare()
    {
        Platforms platform1 = new Platform(150, 294); 
        Platforms platform2 = new Platform(450, 295);
        Platforms platform3 = new Platform(713, 293); 
        Platforms platform4 = new Platform(858, 297);
        platform4.setRotation(-25);

        // break

        Platforms smallPlatform27 = new SmallPlatform(575, 196);
        Platforms smallPlatform28 = new SmallPlatform(630, 196);
        Platforms smallPlatform29 = new SmallPlatform(690, 196);
        Platforms smallPlatform24 = new SmallPlatform(1865, 283);
        smallPlatform24.setRotation(-30);
        Platforms smallPlatform25 = new SmallPlatform(1899, 250);
        smallPlatform25.setRotation(-80);
        Platforms smallPlatform26 = new SmallPlatform(3398, 37);

        Platforms platform6 = new Platform(1128, 232);
        Platforms platform7 = new Platform(1408, 231);
        Platforms platform8 = new Platform(2047, 227);
        Platforms platform9 = new Platform(2350, 155);
        Platforms platform10 = new Platform(2518, 115);
        Platforms platform13 = new Platform(2764, 117);
        Platforms platform15 = new Platform(2966, 117);
        Platforms platform16 = new Platform(2331, 199);
        Platforms platform17 = new Platform(3220, 37);
        Platforms platform19 = new Platform(7571, 233);
        Platforms platform21 = new Platform(7830, 167);
        Platforms platform23 = new Platform(7900, 120);
        Platforms platform24 = new Platform(8052, 120);
        Platforms platform25 = new Platform(8228, 120);
        Platforms platform26 = new Platform(8349, 227);
        Platforms platform27 = new Platform(8878, 295);
        Platforms platform28 = new Platform(8580, 303);
        Platforms platform29 = new Platform(8887, 199);
        Platforms platform30 = new Platform(1709, 273);
        platform30.setRotation(17);
        Platforms platform53 = new Platform(1828, 287);
        
        Platforms walls = new Platform(2203, 311);
        walls.setRotation(90);
        Platforms walls1 = new Platform(2372, 262);
        walls1.setRotation(90);
        Platforms walls2 = new Platform(2178, 348);
        walls2.setRotation(90);
        Platforms walls3 = new Platform(3073, 183);
        walls3.setRotation(90);
        Platforms walls4 = new Platform(7684, 310);
        walls4.setRotation(90);
        Platforms walls5 = new Platform(7748, 263);
        walls5.setRotation(90);
       
        Boosts boosts = new Boosts(920, 260);
        Boosts boosts2 = new Boosts(1581, 210);
        Boosts boosts3 = new Boosts(1852, 260);
        Boosts boosts4 = new Boosts(8586, 251);
        Boosts boosts5 = new Boosts(3490, 14);
        Boosts boosts6 = new Boosts(5035, 4);
        Boosts boosts7 = new Boosts(5715, -40);

        //break

        Platforms platform31 = new Platform(6235, 134 + a);
        Platforms platform33 = new Platform(6528, 134 + a);
        Platforms platform34 = new Platform(6806, 134 + a);
        Platforms platform35 = new Platform(6889, 135 + a);
        
        Platforms walls6 = new Platform(6082, 280 + a);
        walls6.setRotation(90);
        Platforms walls7 = new Platform(6967, 298 + a);
        walls7.setRotation(90);

        Platforms smallPlatform = new SmallPlatform(7265, 389 + a);
        Platforms smallPlatform2 = new SmallPlatform(7070, 198 + a);
        Platforms smallPlatform3 = new SmallPlatform(7140, 260 + a);
        Platforms smallPlatform4 = new SmallPlatform(7203, 326 + a);

        //break

        Platforms platform37 = new Platform(3455, 398 + i );
        platform37.setRotation(-23);
        Platforms platform38 = new Platform(3889, 237 + i);
        Platforms platform39 = new Platform(4456, 341 + i);
        Platforms platform40 = new Platform(4250, 375 + i);
        platform40.setRotation(13);
        Platforms platform41 = new Platform(4179, 372 + i);
        platform41.setRotation(-13);
        Platforms platform42 = new Platform(3958, 363 + i);
        platform42.setRotation(-8);
        Platforms platform43 = new Platform(4780, 347 + i);
        Platforms platform44 = new Platform(5220, 410 + i);
        Platforms platform45 = new Platform(5054, 405 + i);
        platform45.setRotation(25);
        Platforms platform46 = new Platform(4739, 320 + i);
        platform46.setRotation(15);
        Platforms platform47 = new Platform(5528, 215 + i);
        Platforms platform48 = new Platform(5955, 143 + i);
        platform48.setRotation(-24);
        Platforms platform49 = new Platform(5974, 154 + i);
        Platforms platform50 = new Platform(5674, 410 + i);
        platform50.setRotation(-25);      
        Platforms platform52 = new Platform(5520, 411 + i);

        Platforms smallPlatform5 = new SmallPlatform(3608, 343 + i);
        Platforms smallPlatform6 = new SmallPlatform(4513, 313 + i);
        Platforms smallPlatform9 = new SmallPlatform(4576, 185 + i);
        Platforms smallPlatform10 = new SmallPlatform(4770, 118 + i);
        Platforms smallPlatform11 = new SmallPlatform(4580, 284 + i);
        Platforms smallPlatform12 = new SmallPlatform(4830, 90 + i);
        Platforms smallPlatform13 = new SmallPlatform(4883, 90 + i);
        Platforms smallPlatform14 = new SmallPlatform(5024, 89 + i);
        Platforms smallPlatform15 = new SmallPlatform(5149, 123 + i);
        Platforms smallPlatform16 = new SmallPlatform(5286, 151 + i);
        Platforms smallPlatform17 = new SmallPlatform(5667, 112 + i);
        Platforms smallPlatform18 = new SmallPlatform(5725, 120 + i);
        Platforms smallPlatform19 = new SmallPlatform(7583, 215 + i);
        Platforms smallPlatform20 = new SmallPlatform(7490, 218 + i);
        Platforms smallPlatform21 = new SmallPlatform(7327, 151 + i);
        Platforms smallPlatform22 = new SmallPlatform(7395, 216 + i);
        Platforms smallPlatform23 = new SmallPlatform(5835, 345 + i);

        Platforms walls8 = new Platform(5831, 299 + i);
        walls8.setRotation(90);
        Platforms walls9 = new SmallPlatform(4485, 343 + i);
        walls9.setRotation(90);
        Platforms walls10 = new SmallPlatform(4548, 311 + i);
        walls10.setRotation(90);
        
        Boosts boosts8 = new Boosts(3620, 320 + i);
        Boosts boosts9 = new Boosts(4182, 330 + i);
        Boosts boosts11 = new Boosts(6050, 120 + i);
        Boosts boosts12 = new Boosts(6050, -20 + i);
        Boosts boosts13 = new Boosts(4674, 92 + i);
        Boosts boosts14 = new Boosts(4989, 313 + i);
        Boosts boosts15 = new Boosts(5696, 360 + i);
        
        //initializing static variables

        scoreLabel = new Label(TestScroller.points, 35);
        scoreLabel.setValue("RINGS: " + TestScroller.points);
        addObject(scoreLabel, 80, 40);
        
        finalRing = new FinalRing(8887, 249);
        addObject(finalRing,8887, 199);
    }
}