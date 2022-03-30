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
    private int maxBurn;
    private int value;
    private int damagePercentage;

    public Fire(Dimension worldSize, Building building) {
        this.building = building;
       rand = new Random();

       size = rand.nextInt(18)+2;
       value = rand.nextInt(900) + 100;

       percentage = rand.nextInt(85)+5;
       percentageButDouble = percentage/100.0;
       otherPercentage = rand.nextInt(97)+2;
       otherPercentageButDouble = otherPercentage/100.0;

       damagePercentage = 0;
       maxBurn = 0;

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
        Random rand = new Random();
        if(rand.nextInt(15) == 10) {
            size += rand.nextInt(5);
        }
    }

    public int setXLocation()
    {
        int areaOfBuilding = building.getRightBuildingBorder() - building.getLeftBuildingBorder();
        int variableIllUseForLocation = (int) (areaOfBuilding*percentageButDouble);
        return building.getLeftBuildingBorder()+variableIllUseForLocation;
    }

    public int setYLocation()
    {
        int areaOfBuilding = building.getBottomBorder() - building.getTopBuildingBorder();
        int variableIllUseForLocation = (int) (areaOfBuilding*otherPercentageButDouble);
        return building.getTopBuildingBorder()+variableIllUseForLocation;
    }

    public int getBurnDamage()
    {
        int temp = size;
        if(temp > maxBurn)
        {
            maxBurn = temp;
        }
        return maxBurn;
    }

    public void fireReduce(int water)
    {
       if(water * .2 > getFireSize())
       {
           size = 1;
       }
       else
       {
           size -= water *.2;
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


    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        if(size>1)
        {
            g.drawString(String.valueOf(size), setXLocation() + size, setYLocation()+size);
        }
        g.fillArc(setXLocation(),setYLocation(),size,size,0,360);

        g.drawString("right", right(),bottom()/2+size/2 );
        g.drawString("left", left(), bottom()/2+size/2);
        g.drawString("top", right()/2+size/2, top());
        g.drawString("bottom", right()/2+size/2, bottom());

        g.setColor(ColorUtil.rgb(255,0,0));

    }
}
