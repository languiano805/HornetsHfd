package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;




/**
 * This class is the most complex object and represents
 * the main player charter of this version of the game.
 * The helicopter is represented as a small filled yellow
 * circle with a line emanating from the center of
 * the circle pointing in the direction of the helicopters heading.
 */
public class Helicopter
{
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    private int size = 34;
    private int water = 0;
    private int fuel = 25000;
    private int speed = 0;
    Point location;
    Point centerOfCircle;
    Point lineEndPoint;
    double rotateAmount;
    int distance;

    public Helicopter()
    {
        distance = size*2;
        rotateAmount = 0;
        location = new Point(getStartingX(),getStartingY());
        centerOfCircle = new Point(location.getX()+size/2,
                location.getY()+size/2);
        lineEndPoint = new Point( (int) ((distance)*Math.sin(rotateAmount)
                + centerOfCircle.getX()),
                (int)((distance)*(-Math.cos(rotateAmount)))
                        +centerOfCircle.getY());
    }

    public int getStartingX()
    {
        return DISP_W/2-size/2;
    }

    public int getStartingY()
    {
        return (int) (DISP_H-DISP_H/7);
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
        g.fillArc(location.getX(),location.getY(),size,size,0,360);
    }


}
