package com.zl.chainOfResponsibility;

import com.zl.GameModel;
import com.zl.pojo.Bullet;
import com.zl.pojo.Explode;
import com.zl.pojo.GameObject;
import com.zl.pojo.Tank;

public class BulletTankCollide implements Collide{
    @Override
    public boolean collideWith(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet)o1;
            Tank tank = (Tank)o2;
            if (tank.getGroup() == bullet.group) return false;
            if (bullet.rect.intersects(tank.rect)) {
                bullet.die();
                tank.die();
                GameModel.getInstance().add(new Explode(tank.getX()+ Tank.width/2- Explode.width/2, tank.getY()+ Tank.heigth/2- Explode.heigth/2));
                return true;
            }
        } else if (o2 instanceof Bullet && o1 instanceof Tank){
            return collideWith(o2, o1);
        }
        return false;
    }
}
