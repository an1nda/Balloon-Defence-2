import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The End Goal for the Balloons
 * 
 * @author Aninda Saha
 * @version Jan 2021
 */
public class FinishLine extends Actor
{
    /**
     * Act - Actively checks if a Balloon has touched it. 
     * This method is called whenever the 'Act' or 'Run' 
     * button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        missedBalloon();
    }    
    
    /**
     * This method checks if a Balloon is touching the 
     * finish line and updates the health value in
     * the MyWorld class.
     */
    public void missedBalloon()
    {
        if(isTouching(Balloon.class))
        {
            removeTouching(Balloon.class);
            MyWorld world = (MyWorld) getWorld();
            world.balloonFinish();
        }
    }
}
