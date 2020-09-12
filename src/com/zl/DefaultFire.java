package com.zl;

import com.zl.enums.Group;
import com.zl.pojo.DefaultBullet;
import com.zl.pojo.DefaultTank;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/11 11:43
 * @Version 1.0
 */
public class DefaultFire implements FireStrategy{

    private static DefaultFire defaultFire = new DefaultFire();

    private DefaultFire(){}

    @Override
    public void fire(DefaultTank t) {
        int bx = t.getX() - DefaultBullet.width / 2 + DefaultTank.width / 2;
        int by = t.getY() - DefaultBullet.heigth / 2 + DefaultTank.heigth / 2;
        new DefaultBullet(bx, by, t.getDir(), t.getGroup(), t.tankFrame);
        if (t.getGroup() == Group.GOOD)
            new Thread(()->{
                new Audio("com/zl/audio/tank_fire.wav").play();
            }).start();
    }

    public static DefaultFire getInstance(){
        return defaultFire;
    }

}
