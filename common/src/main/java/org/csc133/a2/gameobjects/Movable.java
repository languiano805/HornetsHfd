package org.csc133.a2.gameobjects;

/**
 * The abstract Moveable class also extends GameObject and is used to represent
 * the game objects that are able to move.
 * These Objects have a heading and a speed. Note that being moveable and
 * having a heading doesn't mean that you can necessarily change the object
 * heading.
 */
public abstract class Movable extends GameObject {


    public abstract void steerLeft();

    public abstract void steerRight();


}

