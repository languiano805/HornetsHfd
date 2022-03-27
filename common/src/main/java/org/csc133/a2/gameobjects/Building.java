package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;


public class Building extends Fixed {
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    private int x;
    private int y;
    private int w;
    private int h;
    private int fuel;

    public Building(Dimension worldSize, int x, int y, int w, int h)
    {
        this.worldSize = worldSize;
        this.color = ColorUtil.rgb(255,0,0);
        this.location = new Point2D(0,worldSize.getHeight());
        this.dimension = new Dimension(worldSize.getWidth(),worldSize.getHeight());

        fuel = 25000;

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void drawBuilding(Graphics g)
    {
        //MAY NEED TO PASS IN WIDTH AND LENGTH OF BUILDINGS
        g.setColor(ColorUtil.rgb(250,0,0));
        g.drawRect(x,y,DISP_W/8+w,
                (int) (DISP_H*0.4)+h);
    }


    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        int x2 = containerOrigin.getX()+x;
        int y2 = containerOrigin.getY()+y;
        int w2 = dimension.getWidth()/8+w;
        int h2 = (int) (dimension.getHeight()*0.4)+h;
        g.drawRect(x2,y2,w2,h2);
    }

}
