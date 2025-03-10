import java.awt.Color;
import java.awt.geom.*;
import java.awt.*;
import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes / edited by Oscar Pinto
 * @version 2016.02.29/ edit on 3/07/2024
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        myCanvas.setVisible(true);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    public void boxBounce(int numOfBalls)
    {
         myCanvas.setVisible(true);
         // draws the rectangle box when boxBounce is excecuted
         Rectangle box= new Rectangle(50, 50, 300, 300);
         myCanvas.draw(box);
         
         // create and show the balls
         Random random = new Random();
         HashSet<BoxBall>balls= new HashSet<>();
         for (int i=0; i<numOfBalls; i++)
         {
             Dimension size = myCanvas.getSize();
             int x = (int) box.getX() + (int)box.getWidth() - 16;
             int y = (int) box.getY() +(int) box.getHeight() - 16;
             int xSpeed= random.nextInt(30);
             int ySpeed= random.nextInt(30);
             Color color = new Color( random. nextInt(256), random. nextInt(256),random.nextInt(256));
             BoxBall ball= new BoxBall ( x, y, xSpeed, ySpeed, 16, color, box, myCanvas);
             balls.add(ball);
             ball.draw();
         }
         
         // make the balls bounce 
         boolean finished= false;
         while (!finished)
         {
             myCanvas.wait(50);
             Iterator<BoxBall> it = balls.iterator();
              finished= true;
              while( it.hasNext())
              {
                  BoxBall ball= it. next();
                  ball.move();
                  // stop when all the balls stop
                  if(ball.isMoving())
                  {
                      finished= false;
                  }
              }
         }
         Iterator<BoxBall> it = balls.iterator();
         while(it.hasNext())
         {
             BoxBall ball= it.next();
             ball.erase();
         }
        }
            
         
         public void drawFrame()
         {
             int borderSize= 20;
             Dimension size= myCanvas.getSize();
             Rectangle r = new Rectangle(borderSize, borderSize, (int) size.getWidth() - 2*borderSize, (int) size.getHeight() - 2*borderSize);
             myCanvas.draw(r);
             
         }
         
         }
        
        

