package com.zl;

import com.zl.chainOfResponsibility.BulletTankCollide;
import com.zl.chainOfResponsibility.CollideChain;
import com.zl.chainOfResponsibility.TankTankCollide;
import com.zl.config.PropertiesManager;
import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.Bullet;
import com.zl.pojo.Explode;
import com.zl.pojo.GameObject;
import com.zl.pojo.Tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zl
 * @Date 2020/9/14 14:27
 * @Version 1.0
 */
public class GameModel {
    PropertiesManager propertiesManager = PropertiesManager.getPropertiesManagerInstance();

    Tank myTank = new Tank(200,400, Dir.DOWN, Group.GOOD, this);

    public List<GameObject> gameObjects = new ArrayList<>();

    CollideChain chain = new CollideChain();

    public GameModel(){
        int tankCount = propertiesManager.getIntConfig("initTankCount");
        for(int i = 0; i < tankCount; i++)
            gameObjects.add(new Tank(i*60, 200, Dir.DOWN, Group.BAD, this));
    }




    public void paint(Graphics g) {
//        g.drawString("子弹数量："+bulletList.size(),10,60);
//        g.drawString("敌人数量："+tankList.size(),10,80);
//        g.drawString("消灭敌人数量："+explodeList.size(),10,100);
        myTank.paint(g);
//        for (Bullet bullet : bulletList) { //这种迭代在过程中不允许删除元素
//            bullet.paint(g);
//        }
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

//        for (int i = 0; i < bulletList.size(); i++) {
//            for (int j = 0; j < tankList.size(); j++) {
//                bulletList.get(i).collideWith(tankList.get(j));
//            }
//        }

    }

    public boolean collideWith(){
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = i+1; j < gameObjects.size(); j++) {
                CollideChain chain = new CollideChain();
                if (chain.collideWith(gameObjects.get(i), gameObjects.get(j), this)){
                    break;
                };
            }
        }
        return true;
    }


}
