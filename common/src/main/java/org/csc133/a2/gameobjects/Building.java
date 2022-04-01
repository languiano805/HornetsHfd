package org.csc133.a2.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

import java.util.Random;

import static java.lang.Math.abs;


public class Building extends Fixed {
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    Random rand;

    private int x;
    private int y;
    private int w;
    private int h;
    private int fuel;
    private int damage;
    private int valueOfBuilding;
    private int originalValue;

    private int temp;
    private int damageFromGreatestBurn;

    private int leftBorder;
    private int rightBorder;
    private int topBorder;
    private int bottomBorder;

    private int damageDoneToBuilding;

    private int compareTotalFireValue;

    public Building(Dimension worldSize, int x, int y, int w, int h)
    {
        rand = new Random();
        this.worldSize = worldSize;
        this.color = ColorUtil.rgb(255,0,0);
        this.location = new Point2D(0,worldSize.getHeight());
        this.dimension = new Dimension(worldSize.getWidth(),worldSize.getHeight());

        damageDoneToBuilding = 0;
        compareTotalFireValue = 0;

        valueOfBuilding = rand.nextInt(900)+100;
        originalValue = valueOfBuilding;

        fuel = 25000;
        damage = 0;

        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    //for passing dimensions to the fire to set location
    //
    public int getLeftBuildingBorder()
    {
        return leftBorder;
    }

    public int getRightBuildingBorder()
    {
        return rightBorder;
    }

    public int getTopBuildingBorder()
    {
        return topBorder;
    }

    public int getBottomBorder()
    {
        return bottomBorder;
    }

    //fire building interaction
    public void editBuildingValue(int totalFireDamage)
    {
        int difference = 0;
        if(totalFireDamage > compareTotalFireValue)
        {
            difference = totalFireDamage - compareTotalFireValue;
            compareTotalFireValue = totalFireDamage;
            setValueOfBuilding(difference);
        }

    }

    public void setValueOfBuilding(int changeInBuildingValue)
    {
        valueOfBuilding-=changeInBuildingValue;
        damageDoneToBuilding+=changeInBuildingValue;
    }

    public int getDamageDoneToBuilding()
    {
        return damageDoneToBuilding;
    }

    public int getPercentageOfDamage()
    {
        double perc = (double)(valueOfBuilding)/(double)(originalValue);
        return (int) (100 - (perc*100));
    }

    public int getBuildingValue() {
        return valueOfBuilding;
    }

    public int getOriginalValueOfBuilding()
    {
        return originalValue;
    }

    public boolean isBuildingDestroyed()
    {
        if(getPercentageOfDamage() >= 100)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    @Override
    public void draw(Graphics g, Point containerOrigin) {
        g.setColor(color);
        int x2 = containerOrigin.getX()+x;
        int y2 = containerOrigin.getY()+y;
        int w2 = dimension.getWidth()/8+w;
        int h2 = (int) (dimension.getHeight()*0.4)+h;
        g.drawRect(x2,y2,w2,h2);
        g.drawString("V: " + originalValue, (int) (x2+w2+15), (int) (y2+h2-60));
        g.drawString("D: " + getPercentageOfDamage() + "%", x2+w2+15,y2+h2-35);

        leftBorder = x2;
        rightBorder = x2+w2;
        topBorder = y2;
        bottomBorder = y2+h2;

//        g.drawString("left " + leftBorder, leftBorder, bottomBorder/2);
//        g.drawString("right " + rightBorder, rightBorder, bottomBorder/2);
//        g.drawString("bottom " + bottomBorder, rightBorder/2, bottomBorder);
//        g.drawString("top " + topBorder, rightBorder/2, topBorder);
    }

}
