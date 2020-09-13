package com.zl.tankGroupFactory;

import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.DefaultBullet;
import com.zl.pojo.DefaultExplode;
import com.zl.pojo.DefaultTank;
import com.zl.pojo.abstractTankGroup.BaseBullet;
import com.zl.pojo.abstractTankGroup.BaseExplode;
import com.zl.pojo.abstractTankGroup.BaseTank;

public class DefaultTankGroup extends BaseTankGroup{
    @Override
    public BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new DefaultTank(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExplode creatExplode(int x, int y, TankFrame tankFrame) {
        return new DefaultExplode(x, y, tankFrame);
    }

    @Override
    public BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new DefaultBullet(x, y, dir, group, tf);
    }
}
