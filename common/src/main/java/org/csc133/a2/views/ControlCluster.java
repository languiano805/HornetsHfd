package org.csc133.a2.views;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a2.GameWorld;
import org.csc133.a2.commands.*;

public class ControlCluster extends Container {
    GameWorld gw;

    public ControlCluster(GameWorld gw) {
        this.gw = gw;
        this.getStyle().setBgTransparency(255);
        this.setLayout(new GridLayout(1,9));
        Button leftButton = new Button("leftButton");
        Button rightButton = new Button("rightButton");
        Button fightButton = new Button("fightButton");
        Button exitButton = new Button("exitButton");
        Button drinkButton = new Button("Drink");
        Button brakeButton = new Button("Brake");
        Button accelButton = new Button("Accel");
        Label firstBlank = new Label("   ");
        Label secondBlank = new Label("   ");
        exitButton.setCommand(new ExitButton(gw));
        leftButton.setCommand(new LeftButton(gw));
        rightButton.setCommand(new RightButton(gw));
        fightButton.setCommand(new FightButton(gw));
        drinkButton.setCommand(new DrinkButton(gw));
        brakeButton.setCommand(new BrakeButton(gw));
        accelButton.setCommand(new AccelButton(gw));

        this.add(leftButton);
        this.add(rightButton);
        this.add(fightButton);
        this.add(firstBlank);
        this.add(exitButton);
        this.add(secondBlank);
        this.add(drinkButton);
        this.add(brakeButton);
        this.add(accelButton);
    }
}
