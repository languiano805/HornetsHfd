package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

/**
 * this class represents a single fire turning on the abstract campus.
 * The fire is represented on the screen by a magenta circle.
 */
public class Helipad
{
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    private Point helipadCenter;
    private int sizeOfHelipad;

    public Helipad() {
        sizeOfHelipad = (int) (DISP_W * 0.07);
        helipadCenter = new Point(DISP_W / 2 - sizeOfHelipad / 2,
                DISP_H - DISP_H / 7 - sizeOfHelipad / 2);
    }

    public void drawHelipad(Graphics g) {
        g.setColor(ColorUtil.GRAY);
        g.drawArc(helipadCenter.getX(), helipadCenter.getY(),
                sizeOfHelipad, sizeOfHelipad, 0, 360);
        //CHANGE THE -10 NEED TO MAKE IT SCALABLE
        g.drawRect(helipadCenter.getX() - 10, helipadCenter.getY() - 10,
                (int) (sizeOfHelipad * 1.15), (int) (sizeOfHelipad * 1.15), 5);

    }
}
