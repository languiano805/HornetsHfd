package org.csc133.a2.gameobjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class ObjectInteraction extends Fixed{

   public static void changeBuildingValue(Fires fires){
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
    @Override
    public void draw(Graphics g, Point containerOrigin) {

    }
}
