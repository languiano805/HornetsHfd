package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.util.UITimer;


class Game extends Form implements Runnable {
    private GameWorld gw;

    public Game() {
        gw = new GameWorld();

        addKeyListener('Q', (evt) -> gw.quit());
        //other key listeners
        addKeyListener(-91, (evt) -> gw.arrowUp());
        addKeyListener(-93, (evt) -> gw.arrowLeft());
        addKeyListener(-94, (evt) -> gw.arrowRight());
        addKeyListener(-92, (evt) -> gw.arrowDown());
//        addKeyListener('d',(evt) -> gw.drinkFromWater());
//        addKeyListener('f',(evt) -> gw.fightFire());

        UITimer timer = new UITimer(this);
        timer.schedule(100, true, this);
        this.getAllStyles().setBgColor(ColorUtil.BLACK);
        this.show();


    }


    @Override
    public void run() {
        gw.tick();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        gw.draw(g);
    }

}
