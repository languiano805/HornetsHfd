package org.csc133.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import org.csc133.a2.GameWorld;

public class ExitButton extends Command {
    private GameWorld gw;

    public ExitButton(GameWorld gw)
    {
        super("ExitButton");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        gw.quit();
    }
}
