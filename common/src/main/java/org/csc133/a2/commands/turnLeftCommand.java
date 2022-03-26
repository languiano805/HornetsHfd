package org.csc133.a2.commands;

import org.csc133.a2.gameobjects.Helicopter;

public class turnLeftCommand {
    public static void turnLeft(Helicopter helicopter)
    {
        helicopter.steerLeft();;
    }
}
