package com.zl.pojo.abstractTankGroup;

import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;

import java.awt.*;

public abstract class BaseBullet {

    //位置
    public int x, y;
    //方向
    public Dir dir;
    //子弹是否活着
    public boolean living = true;

    public Group group = null;

    public TankFrame tf = null;

    public Rectangle rect = new Rectangle();

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void die() {
        this.living = false;
    }

    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank baseTank);

    public abstract void move();
}
