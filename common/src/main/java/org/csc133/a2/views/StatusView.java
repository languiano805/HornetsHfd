package org.csc133.a2.views;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.GameWorld;

public class StatusView extends Container
{
    GameWorld gw;
    Label headingCount;
    Label speedCount;
    Label fuelCount;
    Label firesCount;
    Label fireSizeCount;
    Label damageCount;
    Label lossCount;

    public StatusView(GameWorld gw)
    {
        this.gw = gw;
        this.setLayout(new GridLayout(2,7));
        this.add("HEADING");
        this.add("SPEED");
        this.add("FUEL");
        this.add("FIRES");
        this.add("FIRE SIZE");
        this.add("DAMAGE");
        this.add("LOSS");

        headingCount = new Label("0");
        speedCount = new Label("0");
        fuelCount = new Label("0");
        firesCount = new Label("0");
        fireSizeCount = new Label("0");
        damageCount = new Label("0");
        lossCount = new Label("0");

        this.add(headingCount);
        this.add(speedCount);
        this.add(fuelCount);
        this.add(firesCount);
        this.add(fireSizeCount);
        this.add(damageCount);
        this.add(lossCount);
    }

    public void update()
    {
        headingCount.setText(gw.getNumberOfHeading());
        speedCount.setText(gw.getNumberOfSpeed());
        fuelCount.setText(gw.getNumberOfFuel());
        firesCount.setText(gw.getNumberOfFires());
        fireSizeCount.setText(gw.getNumberOfFireCount());
        damageCount.setText(gw.getNumberOfDamage());
        lossCount.setText(gw.getNumberOfLoss());

    }

}
