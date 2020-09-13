package com.zl.pojo;

import com.zl.ResourceImage;
import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.abstractTankGroup.BaseTank;
import com.zl.strategy.DefaultFire;
import com.zl.strategy.FourDirFire;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class AdvanceTank extends BaseTank {

    //坦克宽高
    public static int width = ResourceImage.goodTankU2.getWidth();
    public static int heigth = ResourceImage.goodTankU2.getHeight();

    public AdvanceTank(int x, int y, Dir dir, Group group, TankFrame tankFrame){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = width;
        rect.height = heigth;
    }

    @Override
    public void paint(Graphics g) {

        if (!living) {
            tankFrame.tankList.remove(this);
        }

        /*x+=20;
        y+=20;*/
        BufferedImage image = null;
        if (this.group == Group.BAD){
            switch (dir) {
                case UP:
                    image = ResourceImage.badTankU;
                    break;
                case DOWN:
                    image = ResourceImage.badTankD;
                    break;
                case LEFT:
                    image = ResourceImage.badTankL;
                    break;
                case RIGHT:
                    image = ResourceImage.badTankR;
                    break;
            }
        } else {
            switch (dir) {
                case UP:
                    image = ResourceImage.goodTankU2;
                    break;
                case DOWN:
                    image = ResourceImage.goodTankD2;
                    break;
                case LEFT:
                    image = ResourceImage.goodTankL2;
                    break;
                case RIGHT:
                    image = ResourceImage.goodTankR2;
                    break;
            }
        }

        g.drawImage(image, x, y, null);

        move();
    }

    @Override
    public void fire(int code) {
        if (code == KeyEvent.VK_CONTROL) {
            DefaultFire.getInstance().fire(this, tankFrame);
        }
        if (code == KeyEvent.VK_A){
            FourDirFire.getInstance().fire(this, tankFrame);
        }
    }

    @Override
    public void move() {
        if(!moving) return;

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

        if (this.group == Group.BAD && random.nextInt(100) > 95) this.fire(KeyEvent.VK_CONTROL);
        if (this.group == Group.BAD && random.nextInt(100) > 95) this.randomDir();

        //边界碰撞检查
        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    public void randomDir(){
        this.dir = Dir.values()[random.nextInt(4)];
    }

    @Override
    public void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 30) y = 30;
        if ((this.x > TankFrame.GAME_WIDTH - DefaultTank.width)) x = TankFrame.GAME_WIDTH - DefaultTank.width;
        if ((this.y > TankFrame.GAME_HEIGHT - DefaultTank.heigth)) y = TankFrame.GAME_HEIGHT - DefaultTank.heigth;
    }

}
