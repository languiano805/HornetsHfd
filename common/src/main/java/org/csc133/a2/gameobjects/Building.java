package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.interfaces.Drawable;

public class Building implements Drawable
{
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    private int x;
    private int y;

    public Building(int x, int y)
    {
        this.x =x;
        this.y = y;
    }

    public void drawBuilding(Graphics g)
    {
        //MAY NEED TO PASS IN WIDTH AND LENGTH OF BUILDINGS
        g.setColor(ColorUtil.rgb(250,0,0));
        g.drawRect(x,y,DISP_W/8,
                (int) (DISP_H*0.4));
    }

    @Override
    public void draw(Graphics g, Point containerOrgin) {

    }
}
