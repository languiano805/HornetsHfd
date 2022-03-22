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

//    public void drawHelipad(Graphics g) {
//        g.setColor(ColorUtil.GRAY);
//        g.drawArc(helipadCenter.getX(), helipadCenter.getY(),
//                sizeOfHelipad, sizeOfHelipad, 0, 360);
//        //CHANGE THE -10 NEED TO MAKE IT SCALABLE
//        g.drawRect(helipadCenter.getX() - 10, helipadCenter.getY() - 10,
//                (int) (sizeOfHelipad * 1.15), (int) (sizeOfHelipad * 1.15), 5);
//
//    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        int x = (int) (containerOrigin.getX() + location.getX());
        int y = (int) (containerOrigin.getY() + location.getY());
        int w = sizeOfHelipad;
        int h = sizeOfHelipad;
        g.drawRect(x,y,w,h,5);
        g.drawArc((int)(x*1.01),(int)(y*1.005),(int)(sizeOfHelipad*0.9),(int)(sizeOfHelipad*0.9),0,360);
    }
}
