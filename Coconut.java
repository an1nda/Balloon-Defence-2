import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Orangutan's weapon of choice, high speed coconuts.
 * 
 * @author Aninda Saha 
 * @version Jan 2021
 */
public class Coconut extends Actor
{
    GreenfootSound popSound = new GreenfootSound("balloon_pop.wav");
    
    /**
     * Act - Moves the Coconut and actively checks for 
     * collisions. This method is called whenever the 
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        fly();
        popAndMiss();
    }    
    
    /**
     * Moves the Coconut in the direction it is facing.
     */
    public void fly()
    {
        move(50);
    }
    
    /**
     * Checks if the Coconut has hit a balloon or
     * hit the edge, and properly updates the accuracy
     * variables in the MyWorld class.
     */
    public void popAndMiss()
    {
        if(isTouching(Balloon.class))
        {
            removeTouching(Balloon.class);
            popSound.setVolume(63);
            popSound.play();
            MyWorld world = (MyWorld) getWorld();
            world.hit();
            remove();
        }
        else if(isAtEdge())
        {
            MyWorld world = (MyWorld) getWorld();
            world.miss();
            remove();
        }
    }
    
    /**
     * Removes the Coconut from the World.
     */
    public void remove()
    {
        getWorld().removeObject(this);
    }
}
