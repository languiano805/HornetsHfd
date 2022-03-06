package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

/**
 * The abstract Fixed class extends GameObject and is used to represent the game
 * objects that cannot move once placed.
 */

public class Fixed {
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    public Fixed()
    {

    }
    /**
     * This class represents the American River
     * Abstract the river as a simple open blue rectangle approximately
     * One third from the tip of the game window
     */
    public static class River
    {


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

    /**
     * This class represents teh starting and ending location of this game.
     * The helicopter will take off from the helipad and after putting out all the
     * fires will land back on the
     * helipad in order to end the game
     */
    public static class Helipad
    {
        final static int DISP_W = Display.getInstance().getDisplayWidth();
        final static int DISP_H = Display.getInstance().getDisplayHeight();

        private Point helipadCenter;
        private int sizeOfHelipad;

        public Helipad()
        {
            sizeOfHelipad = (int) (DISP_W*0.07);
            helipadCenter = new Point(DISP_W/2-sizeOfHelipad/2,
                    DISP_H-DISP_H/7-sizeOfHelipad/2);
        }

        public void drawHelipad(Graphics g)
        {
            g.setColor(ColorUtil.GRAY);
            g.drawArc(helipadCenter.getX(),helipadCenter.getY(),
                    sizeOfHelipad,sizeOfHelipad,0,360);
            //CHANGE THE -10 NEED TO MAKE IT SCALABLE
            g.drawRect(helipadCenter.getX()-10,helipadCenter.getY()-10,
                    (int) (sizeOfHelipad*1.15), (int) (sizeOfHelipad*1.15),5);

        }
    }

}

