package org.csc133.a2;

import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
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
    private Building building;
    private Building building2;
    private Building building3;

    private ArrayList<GameObject> gameObjects;


    public GameWorld() {
        //worldSize = new Dimension();
    }


    public void init() {

        //MUST GET RID OF MAGIC NUMBERS
        helipad = new Helipad(worldSize);
        river = new River(worldSize);

        //CHANGE THESE COORDS TO FIT BETTER TO SCREEN
        building = new Building(worldSize,(int) (DISP_W * 0.09), DISP_H / 2, 0, 0);
        building2 = new Building(worldSize,(int) (DISP_W * 0.8),
                (int) (DISP_H / 2 + DISP_H * 0.07), 0, (int) -(DISP_H * 0.09));
        building3 = new Building(worldSize,(int) (DISP_W * 0.14), (int) (DISP_H * 0.03),
                (int) (DISP_W * 0.6), (int) -(DISP_H * 0.25));

        fire = new Fire(300, 30, 50);
        fire2 = new Fire(1500, 25, 50);
        fire3 = new Fire(DISP_W / 2, DISP_H / 2 + 50, 50);
        helicopter = new Helicopter(worldSize,DISP_W, DISP_H);

        gameObjects = new ArrayList<>();

        gameObjects.add(helipad);
        gameObjects.add(river);
        gameObjects.add(building);
        gameObjects.add(building2);
        gameObjects.add(building3);
        gameObjects.add(fire);
        gameObjects.add(fire2);
        gameObjects.add(fire3);
        gameObjects.add(helicopter);
    }

    void draw(Graphics g) {
        //helipad.drawHelipad(g);
        //river.drawRiver(g);
        fire.drawFire(g);
        fire2.drawFire(g);
        fire3.drawFire(g);
        helicopter.drawHelicopter(g);
        building.drawBuilding(g);
        building2.drawBuilding(g);
        building3.drawBuilding(g);
    }

    public void tick() {
        helicopter.reduceFuel();
        helicopter.goForward();
    }

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

    public ArrayList<GameObject> getGameObjectCollection()
    {
        return gameObjects;
    }

    public String getNumberOfHeading() {
        return "0";
    }

    public String getNumberOfSpeed() {
        return "0";
    }

    public String getNumberOfFuel() {
        return "0";
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
}
