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
    private River river;
    private Helipad helipad;

    private int centerOfCircleX;
    private int centerOfCircleY;

    public Helicopter(Dimension worldSize, River river, Helipad helipad)
    {
        this.helipad = helipad;
        this.river = river;
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

    public String getSpeed()
    {
        return String.valueOf(speed);
    }

    public int getWater(){
        return water;
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

    public Boolean aboveRiver() {
        Boolean result = false;

        if (river.getLowerBoarder() > centerOfCircle.getY()
                && centerOfCircle.getY() < river.getUpperBoarder()) {
            result = true;
        }
        return result;
    }

    public Boolean aboveFire(Fire fire)
    {
        Boolean result = false;
        if(centerOfCircleX > fire.left() && centerOfCircleX < fire.right() && centerOfCircleY > fire.top()
        && centerOfCircleY  < fire.bottom()){
            result = true;
        }
        return result;
    }

    public Boolean isHelicopterAboveHelipad()
    {
        Boolean result = false;
        if(centerOfCircleX > helipad.getLeft() && centerOfCircleX < helipad.getRight() && centerOfCircleY > helipad.getTop()
                && centerOfCircleY  < helipad.getBottom()){
            result = true;
        }
        return result;
    }

    public void waterRefill()
    {
        if(speed <= 2)
        {
            if(water < 1000)
            {
                water+=100;
            }
        }
    }

    public void dropWater() {
        water = 0;
    }

    public int waterAmount() {
        return water;
    }

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

        g.setColor(color);

        g.drawString("W: " + water, x2+35, y2+35);
        g.drawString("F: " + fuel, x2+35, y2+60);


        g.drawLine(x2,y2,x3,y3);
        g.fillArc(x,y,w,h,0,360);

        centerOfCircleX = x2;
        centerOfCircleY = y2;
    }
}
