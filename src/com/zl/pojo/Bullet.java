package com.zl.pojo;

import com.zl.Audio;
import com.zl.GameModel;
import com.zl.ResourceImage;
import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Description 子弹实体
 * @Author zl
 * @Date 2020/8/15 11:13
 * @Version 1.0
 */
public class Bullet extends GameObject{

    //位置
    private int x, y;
    //方向
    private Dir dir;

    //子弹宽高
    public static int width = ResourceImage.bulletD.getWidth();
    public static int heigth = ResourceImage.bulletD.getHeight();

    public Rectangle rect = new Rectangle();

    private final static int speed = 6;

    //子弹是否活着
    private boolean living = true;

    public Group group = null;

    TankFrame tf = null;


    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = width;
        rect.height = heigth;
        GameModel.getInstance().add(this);
        if (group == Group.GOOD)
        new Thread(()->new Audio("com/zl/audio/tank_fire.wav").play()).start();
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public void paint(Graphics g) {

        if (!living) {
            GameModel.getInstance().remove(this);
        }

//        Color color = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,10,10);
//        g.setColor(color);
        move();
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

    }

    private void move() {
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
        GameModel.getInstance().collideWith();
    }

    /*public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            gm.gameObjects.add(new Explode(tank.getX()+ Tank.width/2- Explode.width/2, tank.getY()+ Tank.heigth/2- Explode.heigth/2, gm));
        }
    }*/

    public void die() {
        this.living = false;
    }
}
