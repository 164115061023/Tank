package com.zl.decorator;

import com.zl.enums.Group;
import com.zl.pojo.GameObject;

import java.awt.*;

public class TailDecorator extends GODecorator {
    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = super.go.x;
        this.y = super.go.y;
        super.paint(g);
        Color color  = g.getColor();
        g.setColor(Color.BLACK);
        g.drawLine(super.go.x, super.go.y, super.go.x-10, super.go.y-20);
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
