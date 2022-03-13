package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;


public class Building extends Fixed {
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    private int x;
    private int y;
    private int w;
    private int h;

    public Building(int x, int y, int w, int h)
    {
        this.x =x;
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

    }
}
