package org.csc133.a2.gameobjects;

import com.codename1.ui.geom.Point2D;

/**
 * The abstract Moveable class also extends GameObject and is used to represent
 * the game objects that are able to move.
 * These Objects have a heading and a speed. Note that being moveable and
 * having a heading doesn't mean that you can necessarily change the object
 * heading.
 */
public abstract class Movable extends GameObject {
    Point2D centerOfCircle;
    Point2D lineEndPoint;
    int size;
    int water;
    int fuel;
    int speed;
    double rotateAmount;
    int distance;
    River river;
    Helipad helipad;
    int heading;
    int centerOfCircleX;
    int centerOfCircleY;

}

