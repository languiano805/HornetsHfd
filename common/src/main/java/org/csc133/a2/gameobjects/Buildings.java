package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Buildings extends GameObjectCollections<Building>{
    public Buildings()
    {
        super();
        this.color = ColorUtil.rgb(255,0,0);
    }
    //a collection of buildings
    //
    @Override
    public void draw(Graphics g, Point containerOrigin) {
        //iterate over the buldings, callings each of the draw methods
        //
        for(Building build : getGameObjects())
        {
            build.draw(g, containerOrigin);
        }
    }


}
