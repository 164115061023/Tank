package com.zl.pojo;

import com.zl.Audio;
import com.zl.GameModel;
import com.zl.ResourceImage;
import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;

import java.awt.*;
import java.util.Random;

/**
 * @Description
 * @Author zl
 * @Date 2020/8/30 21:41
 * @Version 1.0
 */
public class Explode extends GameObject{
    //位置
    private int x , y;

    private boolean living = true;

    //宽高
    public static int width = ResourceImage.explodeList[0].getWidth();
    public static int heigth = ResourceImage.explodeList[0].getHeight();

    GameModel gm;

    int step = 0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
        new Thread(()->new Audio("com/zl/audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceImage.explodeList[step++],x,y,null);
        if (step >= ResourceImage.explodeList.length){
            gm.gameObjects.remove(this);
            step = 0;
        }
    }
}
