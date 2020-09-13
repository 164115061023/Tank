package com.zl.strategy;

import com.zl.TankFrame;
import com.zl.pojo.abstractTankGroup.BaseTank;
import com.zl.utils.Audio;
import com.zl.enums.Group;
import com.zl.pojo.DefaultBullet;
import com.zl.pojo.DefaultTank;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/11 11:43
 * @Version 1.0
 */
public class DefaultFire implements FireStrategy {

    private static FireStrategy defaultFire = new DefaultFire();

    private DefaultFire(){}

    @Override
    public void fire(BaseTank t, TankFrame tankFrame) {
        int bx = t.getX() - DefaultBullet.width / 2 + DefaultTank.width / 2;
        int by = t.getY() - DefaultBullet.heigth / 2 + DefaultTank.heigth / 2;
        if (t.group == Group.GOOD)
            tankFrame.baseTankGroup.creatBullet(bx, by, t.getDir(), t.getGroup(), tankFrame);
        else
            new DefaultBullet(bx, by, t.getDir(), t.getGroup(), tankFrame);
        if (t.getGroup() == Group.GOOD)
            new Thread(()->{
                new Audio("com/zl/audio/tank_fire.wav").play();
            }).start();
    }

    public static FireStrategy getInstance(){
        return defaultFire;
    }

}
