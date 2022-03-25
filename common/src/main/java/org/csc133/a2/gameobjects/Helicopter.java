package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;


/**
 * This class is the most complex object and represents
 * the main player charter of this version of the game.
 * The helicopter is represented as a small filled yellow
 * circle with a line emanating from the center of
 * the circle pointing in the direction of the helicopters heading.
 */
public class Helicopter extends Movable
{
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    private int size = 34;
    private int water = 0;
    private int fuel = 25000;
    private int speed = 0;
    Point locationOfHelicopter;
    Point centerOfCircle;
    Point lineEndPoint;
    double rotateAmount;
    int distance;
    int x;
    int y;

    public Helicopter(Dimension worldSize, int x, int y)
    {
        this.worldSize = worldSize;
        this.color = ColorUtil.YELLOW;
        this.location = new Point2D(worldSize.getWidth(),worldSize.getHeight());
        this.dimension = new Dimension(worldSize.getWidth(),worldSize.getHeight());

        this.x = x;
        this.y = y;
        distance = size*2;
        rotateAmount = 0;
        locationOfHelicopter = new Point(getStartingX(),getStartingY());
        centerOfCircle = new Point(locationOfHelicopter.getX()+size/2,
                locationOfHelicopter.getY()+size/2);
        lineEndPoint = new Point( (int) ((distance)*Math.sin(rotateAmount)
                + centerOfCircle.getX()),
                (int)((distance)*(-Math.cos(rotateAmount)))
                        +centerOfCircle.getY());
    }

    public int getStartingX()
    {
        return x/2-size/2;
    }

    public int getStartingY()
    {
        return (int) (y-y/7);
    }

    public void goForward()
    {
        int shiftYCoord = (((centerOfCircle.getY()
                -lineEndPoint.getY())/30)*speed);
        lineEndPoint.setY(lineEndPoint.getY()-shiftYCoord);
        centerOfCircle.setY(centerOfCircle.getY()-shiftYCoord);
        location.setY(location.getY()-shiftYCoord);

        int shiftXCoord = (((centerOfCircle.getX()
                - lineEndPoint.getX())/30)*speed);
        location.setX(location.getX()-shiftXCoord);
        lineEndPoint.setX(lineEndPoint.getX()-shiftXCoord);
        centerOfCircle.setX(centerOfCircle.getX() - shiftXCoord);
    }

    @Override
    public void steerLeft()
    {
        rotateAmount-=Math.PI/6.0;
        lineEndPoint = new Point((int)((distance)
                * Math.sin(rotateAmount)) + centerOfCircle.getX(),
                (int)(((distance)* -Math.cos(rotateAmount))
                        +centerOfCircle.getY()));
    }

    @Override
    public void steerRight()
    {
        rotateAmount+=Math.PI/6.0;
        lineEndPoint = new Point((int)((distance)
                * Math.sin(rotateAmount)) + centerOfCircle.getX(),
                (int)(((distance)* -Math.cos(rotateAmount))
                        +centerOfCircle.getY()));
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
    public int getX(){
        return (x/2)-size/2;
    }
    public int getY(){
        return (y-y/7);
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

    public void drawHelicopter(Graphics g)
    {
        g.setColor(ColorUtil.YELLOW);
        g.drawString("W :" + water,centerOfCircle.getX()+35
                ,centerOfCircle.getY()+35);
        g.drawString("F: " + fuel, centerOfCircle.getX()+35,
                centerOfCircle.getY()+50);
        g.drawLine(centerOfCircle.getX(),centerOfCircle.getY(),
                lineEndPoint.getX(),lineEndPoint.getY());
        g.fillArc(locationOfHelicopter.getX(),locationOfHelicopter.getY(),size,size,0,360);
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        drawHelicopter(g);
    }
}
