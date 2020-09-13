package com.zl.pojo.abstractTankGroup;

import com.zl.TankFrame;

import java.awt.*;

public abstract class BaseExplode {
    //位置
    public int x , y;

    public boolean living = true;

    public TankFrame tankFrame;

    public abstract void paint(Graphics g);
}
