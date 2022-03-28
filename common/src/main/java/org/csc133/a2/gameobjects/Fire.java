package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import org.csc133.a2.GameWorld;


import java.util.Random;

public class Fire extends Fixed
{
    private Random rand;

    private int size;
    private int xLocation;

    public Fire(Dimension worldSize, Building building) {
       rand = new Random();
       size = rand.nextInt(18)+2;
       this.worldSize = worldSize;
       this.color = ColorUtil.MAGENTA;
       this.location = new Point2D(xLocation,400);
       this.dimension = new Dimension(size, size);
    }

    public int getFireSize() {
        return size;
    }

//    public void drawFire(Graphics g) {
//        g.setColor(ColorUtil.MAGENTA);
//        if (size > 1) {
//            g.drawString("W: " + size, (x + size), (y + size));
//        }
//        g.setColor(ColorUtil.MAGENTA);
//        g.fillArc(x, y, size, size, 0, 360);
//        g.setColor(ColorUtil.YELLOW);
//    }


    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        int x = (int) (containerOrigin.getX() + location.getX());
        int y = (int) (containerOrigin.getY() + location.getY());
        int w = dimension.getWidth();
        int h = dimension.getHeight();
        if(size>1)
        {
            g.drawString(String.valueOf(size), x + size, y+size);
        }
        g.fillArc(x,y,w,h,0,360);
    }
}
