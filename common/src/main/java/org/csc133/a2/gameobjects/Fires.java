package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Fires extends GameObjectCollections<Fire>{
    public Fires()
    {
        super();
        this.color = ColorUtil.MAGENTA;
    }
    @Override
    public void draw(Graphics g, Point containerOrigin) {
        for(Fire burnThing : getGameObjects())
        {
            burnThing.draw(g, containerOrigin);
        }
    }
}
