package org.csc133.a2;

import com.codename1.ui.Dialog;
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
    private CockPitDisplay fakeCockPit;


    private static int totalValueOfBuildings;
   private Fires fires;
   private static Buildings buildings;

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

        for(Building build : buildings)
        {
            totalValueOfBuildings += build.getBuildingValue();
        }

        helicopter = new Helicopter(worldSize, river, helipad);

        fakeCockPit = new CockPitDisplay(worldSize, helicopter,fires,buildings);

        gameObjects = new ArrayList<>();


        gameObjects.add(helipad);
        gameObjects.add(river);
        gameObjects.add(buildings);
        gameObjects.add(fires);
        gameObjects.add(helicopter);
        gameObjects.add(fakeCockPit);
    }

    public void tick() {
        int buildingsDestroyedCount = 0;
        int numberOfExtinguishedFires = 0;
        int totalBuildingUnits = 0;
        helicopter.reduceFuel();
        helicopter.goForward();
        for(Fire flame : fires)
        {
            if(flame.getFireSize()>1){
                flame.grow();
            }
            flame.setMaxFireSize();
        }
        changeBuildingValue(fires);
        {

        }
        if(helicopter.getFuel() <= 10)
        {
            loseGame();
        }
        for(Building build : buildings)
        {
            if(build.isBuildingDestoryed())
            {
                buildingsDestroyedCount++;
            }
        }
        if(buildingsDestroyedCount == 3)
        {
            loseGame();
        }
        for(Fire flame : fires)
        {
            if(flame.isExtinguished())
            {
                numberOfExtinguishedFires++;
            }
        }
        if(numberOfExtinguishedFires >= 6 && helicopter.isHelicopterAboveHelipad())
        {
            winGame();
        }

    }

    public void loseGame()
    {
        if(Dialog.show("Confirm","You Lose :( )", "Exit", "Replay"))
        {
            quit();
        }
        else
        {
            new Game();
        }
    }

    public void winGame()
    {
        if(Dialog.show("Confirm", "You win Congrats \n You're final score was " + helicopter.getFuel(), "Exit", "Replay"))
        {
            quit();
        }
        else
        {
            new Game();
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
        for(Fire flame : fires)
        {
            if(helicopter.aboveFire(flame) && helicopter.waterAmount() > 0)
            {
                flame.fireReduce(helicopter.waterAmount());
            }
        }
        helicopter.dropWater();
    }

    public void changeBuildingValue(Fires fires){
        int totalFireDamage = 0;
        Building compareBuild = fires.get(0).getBuilding();
        for(Fire flame : fires)
        {
            if(compareBuild == flame.getBuilding())
            {
                totalFireDamage+=flame.getMaxFireSize();
                if(flame == fires.get(fires.size()-1))
                {
                    compareBuild.editBuildingValue(totalFireDamage);
                }
            }
            else
            {
                compareBuild.editBuildingValue(totalFireDamage);
                compareBuild = flame.getBuilding();
                totalFireDamage = flame.getMaxFireSize();
            }
        }
    }

    public static int getTotalPercentageOfBuildingDamage()
    {
        int tempBuildingMaxDamage = 0;
        for(Building build : buildings)
        {
            tempBuildingMaxDamage += build.getBuildingValue();
        }

        return (int) (100-(100*((double)tempBuildingMaxDamage/(double)totalValueOfBuildings)));
    }


}
