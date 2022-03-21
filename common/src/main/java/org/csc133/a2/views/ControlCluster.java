package org.csc133.a2.views;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.GameWorld;

public class ControlCluster extends Container {
    GameWorld gw;
    Button leftButton;
    Button rightButton;
    Button flightButton;
    Button exitButton;
    Button drinkButton;
    Button brakeButton;
    Button accelButton;

    public ControlCluster(GameWorld gw) {
        this.gw = gw;
        this.setLayout(new GridLayout(1,7));
        this.add("leftButton");
        this.add("rightButton");
        this.add("flightButton");
        this.add("exitButton");
        this.add("drinkButton");
        this.add("brakeButton");
        this.add("accelButton");

    }
}
