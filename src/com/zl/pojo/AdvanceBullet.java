package com.zl.pojo;

import com.zl.ResourceImage;
import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.abstractTankGroup.BaseBullet;
import com.zl.pojo.abstractTankGroup.BaseTank;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AdvanceBullet extends BaseBullet {

    private final static int speed = 6;
    //子弹宽高
    public static int width = 8;
    public static int heigth = 8;

    public AdvanceBullet(int x, int y, Dir dir, Group group, TankFrame tf){
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

    @Override
    public void paint(Graphics g) {
        if (!living) {
            tf.bulletList.remove(this);
        }

        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,8,8);
        g.setColor(color);

        g.drawRect(x,y,width,heigth);

        move();
    }

    @Override
    public void collideWith(BaseTank tank) {
        if (this.group == tank.getGroup()) return;
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            tf.explodeList.add(tf.baseTankGroup.creatExplode(tank.getX()+ AdvanceTank.width/2- AdvanceExplode.width/2, tank.getY()+ AdvanceTank.heigth/2- AdvanceExplode.heigth/2, tf));
        }
    }

    @Override
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
}
