package com.zl.tankGroupFactory;

import com.zl.TankFrame;
import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.abstractTankGroup.BaseBullet;
import com.zl.pojo.abstractTankGroup.BaseExplode;
import com.zl.pojo.abstractTankGroup.BaseTank;

public abstract class BaseTankGroup {
    public abstract BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);
    public abstract BaseExplode creatExplode(int x, int y, TankFrame tankFrame);
    public abstract BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf);
}
