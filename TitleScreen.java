import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Title Screen for Balloon Defence 2
 * 
 * @author Aninda Saha
 * @version Jan 2021
 */
public class TitleScreen extends World
{
    static GreenfootSound music = new GreenfootSound("gamemusic.wav");
    Label titleLabel = new Label("Balloon Defence 2", 80);
    Label startInfo = new Label("Press <space> to begin!", 45);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 640x480 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        
        addObject(titleLabel, 320, 180);
        addObject(startInfo, 320, 250);
        
    }
    
    /**
     * Act - Checks for input to change the world to the
     * game world. This method is called whenever the 'Act'
     * or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            gameWorld.resetVar();
            Greenfoot.setWorld(gameWorld);
        }
        
        checkForMusic();
    }
    
    /**
     * This method plays the music and checks if it is still running
     * to prevent the song from playing overtop of itself.
     */
    public void checkForMusic()
    {
        if(!music.isPlaying())
        {
            music.setVolume(20);
            music.playLoop();
        }
        else
        {
            return;
        }
    }
}
