package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;




public class River
{
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    private Point locationOfRiver;
    private int sizeOfRiver;

    public River()
    {
        sizeOfRiver = (int) (DISP_H*0.2);
        locationOfRiver = new Point(DISP_W/2-sizeOfRiver/2,DISP_H/5);
    }

    public void drawRiver(Graphics g)
    {
        g.setColor((ColorUtil.BLUE));
        g.drawRect(0,locationOfRiver.getY(),DISP_W,DISP_H/10,3);
    }


}
