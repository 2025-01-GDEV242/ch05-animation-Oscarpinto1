import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 *
 * @author (Oscar Pinto)
 * @version (3/6/25)
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private int ballDegradation=1;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final Rectangle bounds;
    private Canvas canvas;
    private int xSpeed;
    private int ySpeed;

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int xPos,int yPos, int xSpeed, int ySpeed, int ballDiameter, Color ballColor,
    Rectangle boundingRectangle, Canvas drawingCanvas)
    {
        // initialise instance variables
        xPosition = xPos;
        yPosition= yPos;
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
        color= ballColor;
        diameter= ballDiameter;
        bounds= boundingRectangle;
        canvas= drawingCanvas;
        
    }
    
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
        
    }
    
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }
    

    public void move()
    {
        //remove 
        erase();
        
        // create new position
        yPosition += ySpeed;
        xPosition += xSpeed;
        
        //check if it has hit the border
        if (yPosition>= (bounds.getMaxY()- diameter) && ySpeed>0)
        {
           yPosition= (int) (bounds.getMaxY()- diameter);
           ySpeed = -ySpeed + ballDegradation;
           if (ySpeed>0)
           {
               ySpeed=0;
           }
        }
        
        else if (yPosition<= (bounds.getMinY()) &&ySpeed<0)
        {
            yPosition= (int) (bounds.getMinY())+1;
            ySpeed= -ySpeed - ballDegradation;
            if (ySpeed <0)
            {
                ySpeed=0;
            }
        }
        if(xPosition>=(bounds.getMaxX()) - diameter && xSpeed >0)
        {
            xPosition= (int) ( bounds.getMaxX() -diameter);
            xSpeed= -xSpeed  + ballDegradation;
            if( xSpeed>0)
            {
                xSpeed= 0;
            }
        }
        
        else if (xPosition<= (bounds.getMinX()) && xSpeed< 0) 
        {
            xPosition= (int) (bounds.getMinX())+1;
            xSpeed= -xSpeed- ballDegradation;
            if (xSpeed < 0)
            {
             xSpeed=0;   
            }
            
        }
        
        
        //drae at the new position
        draw();
    }
         /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    /**
     * return true if the ball is still moving
     */
    public boolean isMoving() {
        return (xSpeed != 0  || ySpeed != 0);
    }
        
        
    }
