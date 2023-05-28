import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The balloon racing track being defended by the Orangutan.
 * 
 * @author Aninda Saha
 * @version Jan 2021
 */
public class MyWorld extends World
{
    public static double accuracyNum = 0;
    public static double accuracyDenom = 0;
    public static int score = 0;
    public int health = 8;
    public int speedLevel = 2;
    public int spawnLevel = 1;
    int spawnTime = 50;
    private int spawnTimer;
    public boolean pause = false;
    
    Label scoreLabel;
    Label healthLabel;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 640x480 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        
        FinishLine finish = new FinishLine();
        addObject(finish, 10, 240);
        
        Orangutan orang = new Orangutan();
        addObject(orang, 50, 170);
        
        createBalloon();
        
        scoreLabel = new Label(score, 40);
        addObject(scoreLabel, 610, 20);
        
        healthLabel = new Label("\u2665" + health, 60);
        healthLabel.setFillColor(Color.RED);
        healthLabel.setLineColor(Color.WHITE);
        addObject(healthLabel, 45, 40);
    }
    
    /**
     * Act - Constantly calls the spawnBalloons method, updates
     * the score Label, and checks to see if health is below
     * 1, then changes to the Game Over World. This method is called 
     * whenever the 'Act' or 'Run' button gets pressed in the 
     * environment.
     */
    public void act()
    {
        spawnBalloons();
        
        if(health < 1)
        {
            GameOver end = new GameOver();
            Greenfoot.setWorld(end);
        }
        scoreLabel.setValue(score);
    }
    
    /**
     * This method resets the static values of score,
     * accuracyNum and accuracyDenom to 0.
     */
    public void resetVar()
    {
        accuracyNum = 0;
        accuracyDenom = 0;
        score = 0;
    }
    
    /**
     * This method is called whenever a Coconut object collides
     * with a Balloon object. It increases both accuracy variables
     * and increases the score and updates the score label.
     * Also by using score, the difficulty is increased by altering
     * the speed level and spawn time of the Balloons. The speed
     * of the balloons infinitely increase, but the speed is reset to
     * a slower speed once it gets too fast, to keep the game fair
     * and to give the player/user some more room.
     */
    public void hit()
    {
        accuracyNum += 1;
        accuracyDenom += 1;
        score += 10;
        scoreLabel.setValue(score);
        
        if(score % 150 == 0)
        {
             speedLevel += 1;
        }
        if(score % 50 == 0)
        {
            spawnTime -= 4;
            if(spawnTime < 20)
            {
                spawnTime = 40;
            }
        }
    }
    
    /**
     * This method is called whenever a Coconut hits the 
     * edge of the screen. It increases the denominator
     * value of accuracy by 1 every miss.
     */
    public void miss()
    {
        accuracyDenom += 1;
    }
    
    /**
     * This method is called when a balloon reaches the finish
     * line. It reduces health by one and updates the healthLabel.
     */
    public void balloonFinish()
    {
        health--;
        healthLabel.setValue("\u2665" + health);
    }
    
    /**
     * This method creates balloons randomly on the right side 
     * of the screen.
     */
    public void createBalloon()
    {
        Balloon balloon = new Balloon();
        balloon.increaseSpeed(speedLevel);
        int y = Greenfoot.getRandomNumber(480);
        addObject(balloon, 640, y);
    }
    
    /**
     * This method uses a spawnTimer variable to spawn balloons
     * at a certain interval. This is done by increasing the 
     * spawnTimer value by one until it has a remainder of
     * zero when divided by the spawnTime variable. As it is
     * placed in the act method, it constantly updates and spawns 
     * a balloon when the criteria are met.
     */
    public void spawnBalloons()
    {
        spawnTimer = (spawnTimer + 1) % spawnTime;
        if(spawnTimer == 0)
        {
            createBalloon();
        }
    }
}
