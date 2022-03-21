package org.csc133.a2.gameobjects;

import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point2D;
import org.csc133.a2.interfaces.Drawable;

/**
 * The bastract GameObject lass is the bse of our object heiracy.
 * It contains methods and fields that manage the common aspects of all game
 * objects in our program. Any state or behavior in this class shoud apply to all
 * game objects.
 */

public abstract class GameObject implements Drawable
{
    int color;
    Point2D location;
    Dimension worldSize;
    Dimension dimension;


    public String toString()
    {
        return this.getClass().getSimpleName();
    }
}

