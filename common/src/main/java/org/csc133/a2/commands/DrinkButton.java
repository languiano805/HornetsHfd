package org.csc133.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import org.csc133.a2.GameWorld;

public class DrinkButton extends Command {
    private GameWorld gw;
    public DrinkButton(GameWorld gw)
    {
        super("Drink");
        this.gw =gw;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        gw.getWaterFromRiver();
    }
}
