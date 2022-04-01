package org.csc133.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import org.csc133.a2.GameWorld;

public class RightButton extends Command {
    private GameWorld gw;
    public RightButton(GameWorld gw)
    {
        super("rightButton");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        gw.arrowRight();
    }
}
