package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;


import java.util.Random;

public class Fire extends Fixed
{
    private Random rand;

    private int size;

    private Building building;
    private int percentage;
    private double percentageButDouble;
    private int otherPercentage;
    private double otherPercentageButDouble;
    private int maxFireSize;

    public Fire(Dimension worldSize, Building building) {
        this.building = building;
       rand = new Random();

       size = rand.nextInt(18)+2;
       maxFireSize = size;

       percentage = rand.nextInt(50)+15;
       percentageButDouble = percentage/100.0;
       otherPercentage = rand.nextInt(97)+2;
       otherPercentageButDouble = otherPercentage/100.0;

       this.worldSize = worldSize;
       this.color = ColorUtil.MAGENTA;
       this.location = new Point2D(0,0);
       this.dimension = new Dimension(size, size);
    }

    public int getFireSize() {
        return size;
    }

    public void grow()
    {
        if(!building.isBuildingDestroyed())
        {
            Random rand = new Random();
            if(rand.nextInt(35) == 10) {
                size += rand.nextInt(10);
            }
        }

    }

    public int setXLocation()
    {
        int areaOfBuilding = building.getRightBuildingBorder()
                - building.getLeftBuildingBorder();
        int variableIllUseForLocation =
                (int) (areaOfBuilding*percentageButDouble);
        return building.getLeftBuildingBorder()+variableIllUseForLocation;
    }

    public int setYLocation()
    {
        int areaOfBuilding = building.getBottomBorder()
                - building.getTopBuildingBorder();
        int variableIllUseForLocation =
                (int) (areaOfBuilding*otherPercentageButDouble);
        return building.getTopBuildingBorder()+variableIllUseForLocation;
    }

    public void fireReduce(int water)
    {
       if(water * .07 > getFireSize())
       {
           size = 1;
       }
       else
       {
           size -= water *.07;
       }
    }

    public int right(){
        return setXLocation()+size;
    }

    public int left()
    {
        return setXLocation();
    }

    public int top()
    {
        return setYLocation();
    }

    public int bottom()
    {
        return setYLocation()+size;
    }

    public Building getBuilding()
    {
        return building;
    }

    public void setMaxFireSize()
    {
        if(size > maxFireSize)
        {
            maxFireSize = size;
        }
    }

    public int getMaxFireSize()
    {
        return maxFireSize;
    }

    public boolean isExtinguished()
    {
        if(size <= 1)
        {
            return true;
        }
        return false;
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        if(size>1)
        {
            g.drawString(String.valueOf(size),
                    setXLocation() + size, setYLocation()+size);
            g.drawString(String.valueOf(maxFireSize),
                    setXLocation()+size,setYLocation()+size+20 );
        }
        g.fillArc(setXLocation(),setYLocation(),size,size,0,360);
        g.setColor(ColorUtil.rgb(255,0,0));
    }
}
