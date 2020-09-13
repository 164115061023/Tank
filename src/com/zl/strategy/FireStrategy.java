package com.zl.strategy;

import com.zl.TankFrame;
import com.zl.pojo.DefaultTank;
import com.zl.pojo.abstractTankGroup.BaseTank;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/11 11:42
 * @Version 1.0
 */
public interface FireStrategy {
    void fire(BaseTank t, TankFrame tankFrame);
}
