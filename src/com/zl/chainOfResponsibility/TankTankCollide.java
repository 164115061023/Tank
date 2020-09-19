package com.zl.chainOfResponsibility;

import com.zl.GameModel;
import com.zl.pojo.GameObject;
import com.zl.pojo.Tank;

public class TankTankCollide implements Collide{
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank tank1 = (Tank)o1;
            Tank tank2 = (Tank)o2;
            if (tank1.rect.intersects(tank2.rect)) {
                tank1.setX(tank1.preX);
                tank1.setY(tank1.preY);
                tank2.setX(tank2.preX);
                tank2.setY(tank2.preY);
            }
        }
        return false;
    }
}
