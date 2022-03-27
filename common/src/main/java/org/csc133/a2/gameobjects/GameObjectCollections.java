package org.csc133.a2.gameobjects;

import java.util.ArrayList;

public abstract class GameObjectCollections<T> extends GameObject
{
    ArrayList<T> gameObjects;

    public GameObjectCollections()
    {
        gameObjects = new ArrayList<>();
    }

    ArrayList<T> getGameObjects()
    {
        return gameObjects;
    }

    public void add(T gameObject)
    {
        gameObjects.add(gameObject);
    }

    public void remove(T gameObject)
    {
        gameObjects.remove(gameObject);
    }

    public int getSize()
    {
        return gameObjects.size();
    }

}
