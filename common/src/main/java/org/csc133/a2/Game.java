package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.UITimer;
import org.csc133.a2.views.ControlCluster;
import org.csc133.a2.views.MapView;
import org.csc133.a2.views.StatusView;

public class Game extends Form implements Runnable {
    private GameWorld gw;
    private MapView worldView;
    private StatusView statusView;
    private ControlCluster controlView;

    public Game() {
        gw = new GameWorld();
        setTitle("hfd");

        worldView = new MapView(gw);
        statusView = new StatusView(gw);
        controlView = new ControlCluster(gw);

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, statusView);
        this.add(BorderLayout.CENTER,worldView);
        this.add(BorderLayout.SOUTH, controlView);

        addKeyListener('Q', (evt) -> gw.quit());
        //other key listeners
        addKeyListener(-91, (evt) -> gw.arrowUp());
        addKeyListener(-93, (evt) -> gw.arrowLeft());
        addKeyListener(-94, (evt) -> gw.arrowRight());
        addKeyListener(-92, (evt) -> gw.arrowDown());
        addKeyListener('d',(evt) -> gw.getWaterFromRiver());
        addKeyListener('f',(evt) -> gw.fightFire());

        UITimer timer = new UITimer(this);
        timer.schedule(100, true, this);
        this.getAllStyles().setBgColor(ColorUtil.BLACK);
        this.show();
    }

    @Override
    public void run() {
        gw.tick();
        statusView.update();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

}
