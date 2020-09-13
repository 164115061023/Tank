package com.zl.pojo;

import com.zl.ResourceImage;
import com.zl.TankFrame;
import com.zl.pojo.abstractTankGroup.BaseExplode;
import com.zl.utils.Audio;

import java.awt.*;

public class AdvanceExplode extends BaseExplode {

    //宽高
    public static int width = ResourceImage.explodeList2[6].getWidth();
    public static int heigth = ResourceImage.explodeList2[6].getHeight();

    int step = 0;

    public AdvanceExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        new Thread(()->new Audio("com/zl/audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceImage.explodeList2[step++],x,y,null);
        if (step >= ResourceImage.explodeList2.length){
            tankFrame.explodeList.remove(this);
            step = 0;
        }
    }
}
