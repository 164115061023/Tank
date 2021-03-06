package com.zl;

import com.zl.enums.Group;
import com.zl.pojo.Bullet;
import com.zl.pojo.Tank;

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
    public void fire(Tank t) {
        int bx = t.getX() - Bullet.width / 2 + Tank.width / 2;
        int by = t.getY() - Bullet.heigth / 2 + Tank.heigth / 2;
        new Bullet(bx, by, t.getDir(), t.getGroup(), t.gm);
        if (t.getGroup() == Group.GOOD)
            new Thread(()->{
                new Audio("com/zl/audio/tank_fire.wav").play();
            }).start();
    }

    public static DefaultFire getInstance(){
        return defaultFire;
    }

}
