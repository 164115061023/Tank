package com.zl;

import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.Bullet;
import com.zl.pojo.Tank;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/12 11:52
 * @Version 1.0
 */
public class FourDirFire implements FireStrategy{

    private static FourDirFire fourDirFire = new FourDirFire();
    private FourDirFire(){}

    @Override
    public void fire(Tank t) {
        int bx = t.getX() - Bullet.width / 2 + Tank.width / 2;
        int by = t.getY() - Bullet.heigth / 2 + Tank.heigth / 2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bx, by, dir, t.getGroup());
        }
        if (t.getGroup() == Group.GOOD)
            new Thread(()->{
                new Audio("com/zl/audio/tank_fire.wav").play();
            }).start();
    }


    public static FourDirFire getInstance(){
        return fourDirFire;
    }
}
