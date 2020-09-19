package com.zl.chainOfResponsibility;

import com.zl.GameModel;
import com.zl.pojo.GameObject;

import java.util.LinkedList;
import java.util.List;

public class CollideChain {

    List<Collide> collides = new LinkedList<>();
    public CollideChain(){
        collides.add(new BulletTankCollide());
        collides.add(new TankTankCollide());
        collides.add(new BulletWallCollide());
        collides.add(new TankWallCollide());
    }

    public boolean collideWith(GameObject o1, GameObject o2) {
        for (int i = 0; i < collides.size(); i++) {
            if (collides.get(i).collideWith(o1, o2)){
                break;
            }
        }
        return false;
    }

}
