package org.csc133.a2.commands;

import org.csc133.a2.gameobjects.Helicopter;

public class goForwardCommand {
    public static void goForward(Helicopter helicopter)
    {
        helicopter.increaseSpeed();
    }

}
