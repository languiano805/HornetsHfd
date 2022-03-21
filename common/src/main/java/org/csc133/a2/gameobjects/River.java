package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

/**
 * This class represents the American River
 * Abstract the river as a simple open blue rectangle approximately
 * One third from the tip of the game window
 */
public class River extends Fixed
{
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    private Point locationOfRiver;
    private int sizeOfRiver;

    public River(Dimension worldSize) {
        this.worldSize = worldSize;
        this.color = ColorUtil.BLUE;
        this.location = new Point2D(0, (int)(worldSize.getHeight()*4/5) );
        this.dimension =  new Dimension(worldSize.getWidth(),worldSize.getHeight());

        sizeOfRiver = (int) (DISP_H * 0.2);
        locationOfRiver = new Point(DISP_W / 2 - sizeOfRiver / 2, DISP_H / 5);
    }

//    public void drawRiver(Graphics g) {
//        g.setColor((ColorUtil.BLUE));
//        g.drawRect(0, locationOfRiver.getY(), DISP_W, DISP_H / 10, 3);
//    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        int x = containerOrigin.getX() + (int)location.getX();
        int y = containerOrigin.getY() + (int)location.getY() - worldSize.getHeight();
        int w = dimension.getWidth();
        int h = dimension.getHeight();
        g.drawRect(x,y,w,h);

    }
}
