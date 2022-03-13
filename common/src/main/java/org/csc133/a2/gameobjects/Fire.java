package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import org.csc133.a2.interfaces.Drawable;

public class Fire extends Fixed
{
    private int x;
    private int y;
    private Point location;
    private int size;

    public Fire(int x, int y, int size) {
        this.size = size;
        this.x = x;
        this.y = y;
    }

    public int getFireSize() {
        return size;
    }

    public void drawFire(Graphics g) {
        g.setColor(ColorUtil.MAGENTA);
        if (size > 1) {
            g.drawString("W: " + size, (x + size), (y + size));
        }
        g.setColor(ColorUtil.MAGENTA);
        g.fillArc(x, y, size, size, 0, 360);
        g.setColor(ColorUtil.YELLOW);
    }


    @Override
    public void draw(Graphics g, Point containerOrigin) {

    }
}
