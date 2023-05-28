import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The enemies of the Orangutan trying to complete the race.
 * 
 * @author Aninda Saha 
 * @version Jan 2021
 */
public class Balloon extends Actor
{
    int speed = -3;
    
    /**
     * Act - Moves the balloon at the speed defined. The 
     * value is negative because the balloons move left.
     * This method is called whenever the 'Act' or 'Run'
     * button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(speed);
    }  
    
    /**
     * Takes a parameter and makes it the speed of the balloon.
     * The parameter is multiplied by -1 to make the balloon
     * move left instead of right.
     */
    public void increaseSpeed(int spd)
    {
        speed = (-1) * spd;
    }
    
}
