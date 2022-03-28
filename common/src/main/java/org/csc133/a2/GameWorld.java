package org.csc133.a2;

import com.codename1.ui.Display;
import com.codename1.ui.geom.Dimension;
import org.csc133.a2.gameobjects.*;
import java.util.ArrayList;

public class GameWorld {
    final static int DISP_W = Display.getInstance().getDisplayWidth();
    final static int DISP_H = Display.getInstance().getDisplayHeight();

    Dimension worldSize;

    private Helipad helipad;
    private River river;
    private Helicopter helicopter;
    private Fire fire;
    private Fire fire2;
    private Fire fire3;
    private Fire fire4;
    private Fire fire5;
    private Fire fire6;
    private Building building;
    private Building building2;
    private Building building3;

   private Fires fires;
   private Buildings buildings;

   private ArrayList<GameObject> gameObjects;


//    public GameWorld() {
//
//    }


    public void init() {
        helipad = new Helipad(worldSize);
        river = new River(worldSize);

        //CHANGE THESE COORDS TO FIT BETTER TO SCREEN
        building = new Building(worldSize,(int) (DISP_W * 0.09), (int) (DISP_H / 2.5), 0, 0);
        building2 = new Building(worldSize,(int) (DISP_W * 0.8),
                (int) (DISP_H / 2.5 + DISP_H * 0.02), 0, (int) -(DISP_H * 0.09));
        building3 = new Building(worldSize,(int) (DISP_W * 0.14), (int) (DISP_H * 0.07),
                (int) (DISP_W * 0.6), (int) -(DISP_H * 0.25));

        fire = new Fire(worldSize, building);
        fire2 = new Fire(worldSize, building);
        fire3 = new Fire(worldSize,building2);
        fire4 = new Fire(worldSize,building2);
        fire5 = new Fire(worldSize, building3);
        fire6 = new Fire(worldSize, building3);

        helicopter = new Helicopter(worldSize, river);

        buildings = new Buildings();
        fires = new Fires();

        fires.add(fire);
        fires.add(fire2);
        fires.add(fire3);
        fires.add(fire4);
        fires.add(fire5);
        fires.add(fire6);

        buildings.add(building);
        buildings.add(building2);
        buildings.add(building3);

        gameObjects = new ArrayList<>();

        gameObjects.add(helipad);
        gameObjects.add(river);
        gameObjects.add(buildings);
        gameObjects.add(fires);
        gameObjects.add(helicopter);
    }

    public void tick() {
        helicopter.reduceFuel();
        helicopter.goForward();
        for(Fire flame : fires)
        {
            if(flame.getFireSize()>1){
                flame.grow();
            }
        }
    }


    public ArrayList<GameObject> getGameObjectCollection()
    {
        return gameObjects;
    }

    /////////////////////////
    public String getNumberOfHeading() {
        return "0";
    }

    public String getNumberOfSpeed() {
        return helicopter.getSpeed();
    }

    public String getNumberOfFuel() {
        return String.valueOf(helicopter.getFuel());
    }

    public String getNumberOfFires() {
        return "0";
    }

    public String getNumberOfLoss() {
        return "0";
    }

    public String getNumberOfDamage() {
        return "0";
    }

    public void setDimension(Dimension worldSize)
    {
        this.worldSize = worldSize;
    }

    //movement for the helicopter commands

    public void arrowUp() {
        helicopter.increaseSpeed();
    }

    public void arrowLeft() {
        helicopter.steerLeft();
    }

    public void arrowRight() {
        helicopter.steerRight();
    }

    public void arrowDown() {
        helicopter.decreaseSpeed();
    }

    public void quit() {
        Display.getInstance().exitApplication();
    }

    public String  getNumberOfFireCount() {
        return "0";
    }

    //river and helicopter commands
    //
    public void getWaterFromRiver()
    {
        if(helicopter.aboveRiver())
        {
            helicopter.waterRefill();
        }
    }

    public void fightFire()
    {
        helicopter.dropWater();
    }


}
