package com.zl.pojo.abstractTankGroup;

import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;

import java.awt.*;
import java.util.Random;

public abstract class BaseTank {

    public TankFrame tankFrame;

    //坦克位置
    public int x , y;

    //碰撞检测维护的rect
    public Rectangle rect = new Rectangle();

    //敌我坦克区分
    public Group group = Group.GOOD;

    //坦克方向（默认向下移动）
    public Dir dir = Dir.DOWN;

    //坦克速度
    public final static int speed = 5;

    //坦克是否静止（默认静止）
    public boolean moving = true;

    //坦克是否存活（默认存活）
    public boolean living = true;

    public Random random = new Random();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Group getGroup() {
        return group;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void die() {
        living = false;
    }

    public abstract void paint(Graphics g);

    public abstract void fire(int code);

    public abstract void boundsCheck();

    public abstract void move();
}
