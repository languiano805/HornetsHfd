package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.interfaces.Drawable;

/**
 * This class represents the American River
 * Abstract the river as a simple open blue rectangle approximately
 * One third from the tip of the game window
 */
public class River implements Drawable
{
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    private Point locationOfRiver;
    private int sizeOfRiver;

    public River() {
        sizeOfRiver = (int) (DISP_H * 0.2);
        locationOfRiver = new Point(DISP_W / 2 - sizeOfRiver / 2, DISP_H / 5);
    }

    public void drawRiver(Graphics g) {
        g.setColor((ColorUtil.BLUE));
        g.drawRect(0, locationOfRiver.getY(), DISP_W, DISP_H / 10, 3);
    }

    @Override
    public void draw(Graphics g, Point containerOrgin) {

    }
}
