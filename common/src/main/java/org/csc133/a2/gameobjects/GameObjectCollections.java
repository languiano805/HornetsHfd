package org.csc133.a2.gameobjects;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class GameObjectCollections<T> extends
        GameObject implements Iterable<T>
{
    ArrayList<T> gameObjects;


    class GameObjectIterator implements Iterator<T>
    {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < gameObjects.size();
        }

        @Override
        public T next() {
            return gameObjects.get(index++);
        }
    }

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

    public T get(int x) { return gameObjects.get(x);}

    public void remove(T gameObject)
    {
        gameObjects.remove(gameObject);
    }

    public int size()
    {
        return gameObjects.size();
    }

    @Override
    public Iterator<T> iterator()
    {
        return new GameObjectIterator();
    }

}
