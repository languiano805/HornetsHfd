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
    int lowerBoarder;
    int upperBoarder;

    public River(Dimension worldSize) {
        this.worldSize = worldSize;
        this.color = ColorUtil.BLUE;
        this.location = new Point2D(0, worldSize.getHeight());
        this.dimension =  new Dimension(worldSize.getWidth(),worldSize.getHeight());


    }


    public int getLowerBoarder()
    {
        return lowerBoarder;
    }

    public int getUpperBoarder()
    {
        return upperBoarder;
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        int x = containerOrigin.getX() + (int)location.getX();
        int y = (int) ((containerOrigin.getY() + location.getY() - worldSize.getHeight())*3.5);
        int w = dimension.getWidth();
        int h = (int) (dimension.getHeight()/8.5);
        g.drawRect(x,y,w, h,3);
        g.setColor(ColorUtil.GREEN);
        lowerBoarder = y+125;
        upperBoarder = y-10;
        g.drawString("lower",100,y+125);
        g.drawString("upper",100,y-10);

    }
}
