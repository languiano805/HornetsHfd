package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import org.csc133.a2.interfaces.Steerable;


/**
 * This class is the most complex object and represents
 * the main player charter of this version of the game.
 * The helicopter is represented as a small filled yellow
 * circle with a line emanating from the center of
 * the circle pointing in the direction of the helicopters heading.
 */
public class Helicopter extends GameObject implements Steerable
{
    private Point2D centerOfCircle;
    private Point2D lineEndPoint;

    private int size;
    private int water;
    private int fuel;
    private int speed;
    private double rotateAmount;
    private int distance;

    public Helicopter(Dimension worldSize)
    {
        size = 34;
        water = 0;
        fuel = 25000;
        speed = 0;
        this.worldSize = worldSize;
        this.color = ColorUtil.YELLOW;
        this.dimension = new Dimension(size,size);
        distance = size*2;
        rotateAmount = 0;
        this.location = new Point2D((int)(worldSize.getWidth()/2-dimension.getWidth()/2)
                ,(int)(worldSize.getHeight() - worldSize.getHeight()/5.5));
        this.centerOfCircle = new Point2D(location.getX() + (int)(dimension.getWidth()/2),
                location.getY()+(int)(dimension.getHeight()/2));
        this.lineEndPoint = new Point2D((int) ((distance)*Math.sin(rotateAmount) + centerOfCircle.getX()),
                (int)((distance)*(-Math.cos(rotateAmount))) + centerOfCircle.getY());

    }

    public void goForward()
    {
        int shiftYCoord = (int) (((centerOfCircle.getY()
                        -lineEndPoint.getY())/30)*speed);
        lineEndPoint.setY(lineEndPoint.getY()-shiftYCoord);
        centerOfCircle.setY(centerOfCircle.getY()-shiftYCoord);
        location.setY(location.getY()-shiftYCoord);

        int shiftXCoord = (int) (((centerOfCircle.getX()
                        - lineEndPoint.getX())/30)*speed);
        location.setX(location.getX()-shiftXCoord);
        lineEndPoint.setX(lineEndPoint.getX()-shiftXCoord);
        centerOfCircle.setX(centerOfCircle.getX() - shiftXCoord);
    }

    @Override
    public void steerLeft()
    {
        rotateAmount-=Math.PI/6.0;
        lineEndPoint = new Point2D((int)((distance)
                * Math.sin(rotateAmount)) + centerOfCircle.getX(),
                (int)(((distance)* -Math.cos(rotateAmount))
                        +centerOfCircle.getY()));
    }

    @Override
    public void steerRight()
    {
        rotateAmount+=Math.PI/6.0;
        lineEndPoint = new Point2D((int)(((distance) * Math.sin(rotateAmount)) + centerOfCircle.getX()),
                (int)((((distance)* -Math.cos(rotateAmount))
                        +centerOfCircle.getY())));
    }
    public void increaseSpeed()
    {
        if(speed < 10)
        {
            speed++;
        }
    }
    public void decreaseSpeed()
    {
        if(speed > 0)
        {
            speed--;
        }
    }

    public int getSpeed()
    {
        return speed;
    }

    public void reduceFuel()
    {
        if(fuel > 0)
        {
            fuel-=1;
        }
    }

    public int getFuel()
    {
        return fuel;
    }

//    public void drawHelicopter(Graphics g)
//    {
//        g.setColor(ColorUtil.YELLOW);
//        g.drawString("W :" + water, (int) (centerOfCircle.getX()+35)
//                , (int) (centerOfCircle.getY()+35));
//        g.drawString("F: " + fuel, (int) (centerOfCircle.getX()+35),
//                (int) (centerOfCircle.getY()+50));
//        g.drawLine((int) centerOfCircle.getX(), (int) centerOfCircle.getY(),
//                (int) lineEndPoint.getX(), (int) lineEndPoint.getY());
//        g.fillArc((int) location.getX(), (int) location.getY(),size,size,0,360);
//    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        //for circle
        int x = (int) (containerOrigin.getX() + location.getX());
        int y = (int) (containerOrigin.getY() + location.getY());
        int w = dimension.getWidth();
        int h = dimension.getHeight();
        //for beginning line
        int x2 = (int) (containerOrigin.getX() + centerOfCircle.getX());
        int y2 = (int) (containerOrigin.getY() + centerOfCircle.getY());
        //for end line
        int x3 = (int) (containerOrigin.getX() + lineEndPoint.getX());
        int y3 = (int) (containerOrigin.getY() + lineEndPoint.getY());

        g.drawString("W: " + water, x2+35, y2+35);
        g.drawString("F: " + fuel, x2+35, y2+60);

        g.setColor(color);
        g.drawLine(x2,y2,x3,y3);
        g.fillArc(x,y,w,h,0,360);
    }


}
