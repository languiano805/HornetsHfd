package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

/**
 * this class represents a single fire turning on the abstract campus.
 * The fire is represented on the screen by a magenta circle.
 */
public class Helipad extends Fixed
{
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    private Point helipadCenter;
    private int sizeOfHelipad;

    private int left;
    private int right;
    private int bottom;
    private int top;

    //need to watch how he draws the cloud 
    public Helipad(Dimension worldSize) {
        this.worldSize = worldSize;
        this.color = ColorUtil.GRAY;
        sizeOfHelipad = (int) (DISP_W * 0.07);
        this.location = new Point2D(worldSize.getWidth()/2-sizeOfHelipad/2,
                worldSize.getHeight()*0.7+sizeOfHelipad/2);
        this.dimension = new Dimension(worldSize.getWidth(),worldSize.getHeight());

        helipadCenter = new Point(DISP_W / 2 - sizeOfHelipad / 2,
                DISP_H - DISP_H / 7 - sizeOfHelipad / 2);
    }

    public int getLeft()
    {
        return left;
    }
    public int getRight()
    {
        return right;
    }
    public int getTop()
    {
        return top;
    }
    public int getBottom()
    {
        return bottom;
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        int x = (int) (containerOrigin.getX() + location.getX());
        int y = (int) (containerOrigin.getY() + location.getY());
        int w = sizeOfHelipad;
        int h = sizeOfHelipad;
        left = x;
        top = y;
        right = left+sizeOfHelipad;
        bottom = top+sizeOfHelipad;
        g.drawRect(x,y,w,h,5);
        g.drawArc((int)(x*1.01),(int)(y*1.005),(int)(sizeOfHelipad*0.9),
                (int)(sizeOfHelipad*0.9),0,360);
    }
}
