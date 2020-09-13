package com.zl.pojo;

import com.zl.utils.Audio;
import com.zl.ResourceImage;
import com.zl.TankFrame;
import com.zl.pojo.abstractTankGroup.BaseExplode;

import java.awt.*;

/**
 * @Description
 * @Author zl
 * @Date 2020/8/30 21:41
 * @Version 1.0
 */
public class DefaultExplode extends BaseExplode {

    //宽高
    public static int width = ResourceImage.explodeList[0].getWidth();
    public static int heigth = ResourceImage.explodeList[0].getHeight();

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
