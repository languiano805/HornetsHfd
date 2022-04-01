package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;
import org.csc133.a2.GameWorld;

public class CockPitDisplay extends Fixed{
    private Helicopter helicopter;
    private Fires fires;
    private Buildings buildings;
    private int totalValueOfBuildings;


    public CockPitDisplay(Dimension worldSize, Helicopter helicopter, Fires fires, Buildings buildings){
        this.worldSize = worldSize;
        this.color = ColorUtil.GREEN;
        this.location = new Point2D(0,worldSize.getHeight());
        this.dimension = new Dimension(worldSize.getWidth(), worldSize.getHeight());
        this.helicopter = helicopter;
        this.fires = fires;
        this.buildings = buildings;
        this.location = new Point2D(worldSize.getWidth()*0.05, worldSize.getHeight()*0.05);
        for(Building build : buildings)
        {
            totalValueOfBuildings = build.getBuildingValue();
        }
    }

//    public int getFiresSize()
//    {
//        int totalFireSize = 0;
//        for(Fire flame : fires)
//        {
//            totalFireSize+=flame.getFireSize();
//        }
//        return totalFireSize;
//    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        int x = (int) (containerOrigin.getX()+location.getX());
        int y = (int) (containerOrigin.getY()+location.getY());
        g.drawString("Heading: ", x, y);
        g.drawString("SPEED: " + helicopter.getSpeed(), x,y+30);
        g.drawString("FUEL: " + helicopter.getFuel(), x,y+60);
        g.drawString("FIRES: " + fires.size(), x,y+90);
        //g.drawString("FIRE SIZE: " + getFiresSize(), x,y+120);
        //g.drawString("DAMAGE: " + GameWorld.getTotalPercentageOfBuildingDamage(), x,y+150);
        g.drawString("LOSS: ", x,y+180);
    }
}
