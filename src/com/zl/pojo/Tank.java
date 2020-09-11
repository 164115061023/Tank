package com.zl.pojo;

import com.zl.Audio;
import com.zl.ResourceImage;
import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @Description
 * @Author zl
 * @Date 2020/8/15 10:10
 * @Version 1.0
 */
public class Tank {

    //坦克位置
    private int x , y;
    //坦克速度
    private final static int speed = 5;

    //坦克方向（默认向下移动）
    Dir dir = Dir.DOWN;

    //坦克是否静止（默认静止）
    private boolean moving = true;

    private boolean living = true;

    private Group group = Group.GOOD;

    Random random = new Random();
    //坦克宽高
    public static int width = ResourceImage.goodTankU.getWidth();
    public static int heigth = ResourceImage.goodTankU.getHeight();

    Rectangle rect = new Rectangle();

    public TankFrame tankFrame;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = width;
        rect.height = heigth;
    }


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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {

        if (!living) {
            tankFrame.tankList.remove(this);
        }

        /*x+=20;
        y+=20;*/
        BufferedImage image = null;
        if (this.group == Group.BAD){
            switch (dir) {
                case UP:
                    image = ResourceImage.badTankU;
                    break;
                case DOWN:
                    image = ResourceImage.badTankD;
                    break;
                case LEFT:
                    image = ResourceImage.badTankL;
                    break;
                case RIGHT:
                    image = ResourceImage.badTankR;
                    break;
            }
        } else {
            switch (dir) {
                case UP:
                    image = ResourceImage.goodTankU;
                    break;
                case DOWN:
                    image = ResourceImage.goodTankD;
                    break;
                case LEFT:
                    image = ResourceImage.goodTankL;
                    break;
                case RIGHT:
                    image = ResourceImage.goodTankR;
                    break;
            }
        }

        g.drawImage(image, x, y, null);
        move();
    }

    private void move() {

        if(!moving) return;

        switch (dir){
            case UP:
                y-=speed;
                break;
            case DOWN:
                y+=speed;
                break;
            case LEFT:
                x-=speed;
                break;
            case RIGHT:
                x+=speed;
                break;
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95) this.fire();
        if (this.group == Group.BAD && random.nextInt(100) > 95) this.randomDir();

        //边界碰撞检查
        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 30) y = 30;
        if ((this.x > TankFrame.GAME_WIDTH - Tank.width)) x = TankFrame.GAME_WIDTH - Tank.width;
        if ((this.y > TankFrame.GAME_HEIGHT - Tank.heigth)) y = TankFrame.GAME_HEIGHT - Tank.heigth;
    }

    private void randomDir(){
        this.dir = Dir.values()[random.nextInt(4)];
    }


    public void fire() {
        int bx = this.x - Bullet.width / 2 + Tank.width / 2;
        int by = this.y - Bullet.heigth / 2 + Tank.heigth / 2;
        new Bullet(bx, by, this.dir, this.getGroup(), this.tankFrame);
        if (this.getGroup() == Group.GOOD)
            new Thread(()->{
                new Audio("com/zl/audio/tank_fire.wav").play();
            }).start();
    }

    public void die() {
        living = false;
    }
}
