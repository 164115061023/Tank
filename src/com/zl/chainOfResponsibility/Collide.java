package com.zl.chainOfResponsibility;

import com.zl.GameModel;
import com.zl.pojo.GameObject;

public interface Collide {
    boolean collideWith(GameObject o1, GameObject o2, GameModel gm);

}
