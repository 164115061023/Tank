package com.zl.pojo;

import com.zl.ResourceImage;
import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.abstractTankGroup.BaseBullet;
import com.zl.pojo.abstractTankGroup.BaseTank;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Description 子弹实体
 * @Author zl
 * @Date 2020/8/15 11:13
 * @Version 1.0
 */
public class DefaultBullet extends BaseBullet {

    //子弹宽高
    public static int width = ResourceImage.bulletD.getWidth();
    public static int heigth = ResourceImage.bulletD.getHeight();

    private final static int speed = 6;

    public DefaultBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = width;
        rect.height = heigth;
        tf.bulletList.add(this);
    }


    public void paint(Graphics g) {

        if (!living) {
            tf.bulletList.remove(this);
        }

        BufferedImage image = null;
        switch (dir) {
            case UP:
                image = ResourceImage.bulletU;
                break;
            case DOWN:
                image = ResourceImage.bulletD;
                break;
            case LEFT:
                image = ResourceImage.bulletL;
                break;
            case RIGHT:
                image = ResourceImage.bulletR;
                break;
        }
        g.drawImage(image,x,y,null);
        move();

    }

    public void move() {
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

        rect.x = this.x;
        rect.y = this.y;

        if (x<0 || y<0 || x> TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) living = false;
    }

    public void collideWith(BaseTank tank) {
        if (this.group == tank.getGroup()) return;
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            tf.explodeList.add(tf.baseTankGroup.creatExplode(tank.getX()+ DefaultTank.width/2- DefaultExplode.width/2, tank.getY()+ DefaultTank.heigth/2- DefaultExplode.heigth/2, tf));
        }
    }

}
