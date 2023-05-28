import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Hero of the game, defending the race track from balloons
 * 
 * @author Aninda Saha
 * @version Jan 2021
 */
public class Orangutan extends Actor
{
    GreenfootSound throwSound = new GreenfootSound("coconut_throw.wav");
    
    /**
     * Act - Turns the Orangutan as well as creating the
     * Coconut being thrown. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null)
        {
            turnTo(mouse);
        }
        if(Greenfoot.mouseClicked(null))
        {
            throwCoconut();
            throwSound.setVolume(55);
            throwSound.play();
        }
    }    
    
    /**
     * This method obtains mouse information of the user
     * and creates a new Coconut object turned towards
     * the location of the mouse. The if statement is to
     * prevent errors if the mouse is not giving info.
     */
    public void throwCoconut()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) 
        {
            return;
        }
        int x = mouse.getX();
        int y = mouse.getY();
        Coconut coconut = new Coconut();
        getWorld().addObject(coconut, getX(), getY());
        coconut.turnTowards(x, y);
    }
    
    /**
     * This method turns the image of the orangutan towards
     * the mouse by getting the mouse values as a parameter.
     */
    public void turnTo (MouseInfo mi)
    {
        turnTowards(mi.getX(), mi.getY());
    }
}
