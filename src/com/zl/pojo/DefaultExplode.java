package com.zl.pojo;

import com.zl.Audio;
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
public class DefaultExplode {
    //位置
    private int x , y;

    private boolean living = true;

    //宽高
    public static int width = ResourceImage.explodeList[0].getWidth();
    public static int heigth = ResourceImage.explodeList[0].getHeight();

    private TankFrame tankFrame;

    int step = 0;

    public DefaultExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        new Thread(()->new Audio("com/zl/audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceImage.explodeList[step++],x,y,null);
        if (step >= ResourceImage.explodeList.length){
            tankFrame.explodeList.remove(this);
            step = 0;
        }
    }
}
