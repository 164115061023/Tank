package com.zl.chainOfResponsibility;

import com.zl.GameModel;
import com.zl.pojo.*;

public class BulletWallCollide implements Collide{
    @Override
    public boolean collideWith(GameObject o1, GameObject o2, GameModel gm) {
        if (o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet = (Bullet)o1;
            Wall wall = (Wall) o2;
            if (bullet.rect.intersects(wall.rect)) {
                bullet.die();
            }
        } else if (o2 instanceof Bullet && o1 instanceof Wall){
            return collideWith(o2, o1, gm);
        }
        return false;
    }
}
