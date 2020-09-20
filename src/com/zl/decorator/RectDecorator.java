package com.zl.decorator;

import com.zl.enums.Group;
import com.zl.pojo.GameObject;

import java.awt.*;

public class RectDecorator extends GODecorator {
    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color color  = g.getColor();
        g.setColor(Color.BLACK);
        g.drawRect(super.go.x, super.go.y, getWidth()+2, getHeight()+2);
        g.setColor(color);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }

    @Override
    public Rectangle getRect() {
        return super.go.getRect();
    }

    @Override
    public Group getGroup() {
        return super.go.getGroup();
    }
}
