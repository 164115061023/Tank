package com.zl.tankGroupFactory;

import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.AdvanceBullet;
import com.zl.pojo.AdvanceExplode;
import com.zl.pojo.AdvanceTank;
import com.zl.pojo.DefaultExplode;
import com.zl.pojo.abstractTankGroup.BaseBullet;
import com.zl.pojo.abstractTankGroup.BaseExplode;
import com.zl.pojo.abstractTankGroup.BaseTank;

public class AdvanceTankGroup extends BaseTankGroup{
    @Override
    public BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new AdvanceTank(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExplode creatExplode(int x, int y, TankFrame tankFrame) {
        return new AdvanceExplode(x, y, tankFrame);
    }

    @Override
    public BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new AdvanceBullet(x, y, dir, group, tf);
    }
}
