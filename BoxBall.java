import java.awt.*;
import java.awt.geom.*;
/**
 * BoxBall allows the user to create a method where a rectangle within a canvas is 
 * drawn, alongside the rectangle the user will be prompted to input how many balls
 * he wants to boucne within the rectangle, the balls do not leave the rectangle, 
 * nor do they all bounce at the same speed and direction. 

 *
 * @author (Oscar Pinto)
 * @version (3/6/25)
 */
public class BoxBall
{
    // instance variables 
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
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param xSpeed  the horizontal speed of the ball
     * @param ySpeed  the vertical speed of the ball
     * 
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param bounds the rectangle the ball should bounce withing
     * @param drawingCanvas  the canvas to draw this ball on
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
    /**
     *Draw this ball at the current postiiton it is in on the canvas
     **/
    
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
        
    }
     /**
     *Erase this ball at the current postiiton it is in on the canvas
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }
    
    /**
     *Move this ball based off of its speed and draw it again
     **/
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
        
        
        //draw at the new position
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
