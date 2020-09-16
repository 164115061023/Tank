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
    }

    public boolean collideWith(GameObject o1, GameObject o2, GameModel gm) {
        for (int i = 0; i < collides.size(); i++) {
            if (collides.get(i).collideWith(o1, o2, gm)){
                break;
            }
        }
        return false;
    }

}
