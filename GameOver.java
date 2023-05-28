import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The end screen when the Orangutan runs out of lives.
 * 
 * @author Aninda Saha
 * @version Jan 2021
 */
public class GameOver extends World
{
    MyWorld world = new MyWorld();
    Label scoreLabel = new Label("Score: " + world.score, 50);
    Label gameOver = new Label("Game Over", 110);
    Label accLabel = new Label("Accuracy: " + this.getAccuracy(), 60);
    Label restartInfo = new Label("Press < R > to try again!", 50);
    public static int highScore = 0;
    Label highScoreLabel = new Label("High Score = " + highScore, 40);
    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 1); 
        
        addObject(scoreLabel, 320, 230);
        addObject(gameOver, 320, 160);
        
        addObject(accLabel, 320, 280);
        addObject(restartInfo, 320, 330);
        addObject(highScoreLabel, 320, 390);
    }
    
    /**
     * Act - Checks to see if there is a new high score as well
     * as restarting the game with an input. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld world = new MyWorld();
        if(world.score > highScore)
        {
            highScore = world.score;
            highScoreLabel.setValue("High Score: " + highScore);
        }
        else
        {
            highScoreLabel.setValue("High Score: " + highScore);
        }
        
        if(this.getAccuracyInt() >= 80)
        {
            accLabel.setFillColor(Color.GREEN);
        }
        else if(this.getAccuracyInt() >= 50)
        {
            accLabel.setFillColor(Color.YELLOW);
        }
        else if(this.getAccuracyInt() >= 30)
        {
            accLabel.setFillColor(Color.ORANGE);
        }
        else
        {
            accLabel.setFillColor(Color.RED);
        }
        
        if(Greenfoot.isKeyDown("R"))
        {
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
        }
    }
    
    /**
     * Returns a String value of the accuracy of the player. 
     */
    public String getAccuracy()
    {
        MyWorld world = new MyWorld();
        if(world.accuracyDenom != 0)
        {
            double accuracy = (world.accuracyNum) / (world.accuracyDenom);
            int accRound = (int)accuracy;
            int accValue = (int) ((accuracy - accRound) * 100);
            String acc = accValue + "%";
            return acc;
        }
        else
        {
            return "0%";
        }
    }
    
    /**
     * Returns an int value of the Accuracy
     */
    public int getAccuracyInt()
    {
        MyWorld world = new MyWorld();
        if(world.accuracyDenom != 0)
        {
            double accuracy = (world.accuracyNum) / (world.accuracyDenom);
            int accRound = (int)accuracy;
            int accValue = (int) ((accuracy - accRound) * 100);
            return accValue;
        }
        else
        {
            return 0;
        }
    }
}
