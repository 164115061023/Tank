package com.zl.chainOfResponsibility;

import com.zl.GameModel;
import com.zl.pojo.Bullet;
import com.zl.pojo.GameObject;
import com.zl.pojo.Tank;
import com.zl.pojo.Wall;

public class TankWallCollide implements Collide{
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall){
            Tank tank = (Tank)o1;
            Wall wall = (Wall) o2;
            if (tank.rect.intersects(wall.rect)) {
                tank.setX(tank.preX);
                tank.setY(tank.preY);
            }
        } else if (o2 instanceof Tank && o1 instanceof Wall){
            return collideWith(o2, o1);
        }
        return false;
    }
}
