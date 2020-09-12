package com.zl;

import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.DefaultBullet;
import com.zl.pojo.DefaultTank;

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
    public void fire(DefaultTank t) {
        int bx = t.getX() - DefaultBullet.width / 2 + DefaultTank.width / 2;
        int by = t.getY() - DefaultBullet.heigth / 2 + DefaultTank.heigth / 2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new DefaultBullet(bx, by, dir, t.getGroup(), t.tankFrame);
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
