package com.zl.pojo;

import com.zl.enums.Group;

import java.awt.*;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 16:04
 * @Version 1.0
 */
public abstract class GameObject {
    public int x, y;

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract Rectangle getRect();
    public abstract Group getGroup();

}
