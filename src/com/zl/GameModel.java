package com.zl;

import com.zl.chainOfResponsibility.BulletTankCollide;
import com.zl.chainOfResponsibility.CollideChain;
import com.zl.chainOfResponsibility.TankTankCollide;
import com.zl.config.PropertiesManager;
import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.*;

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

    private static final GameModel gameModel = new GameModel();
    PropertiesManager propertiesManager = PropertiesManager.getPropertiesManagerInstance();

    Tank myTank = new Tank(200,400, Dir.DOWN, Group.GOOD);

    public List<GameObject> gameObjects = new ArrayList<>();

    CollideChain chain = new CollideChain();

    private GameModel(){
        //初始化敌方坦克
        int tankCount = propertiesManager.getIntConfig("initTankCount");
        for(int i = 0; i < tankCount; i++)
            add(new Tank(i*60, 200, Dir.DOWN, Group.BAD));

        add(new Wall(180, 180, 15, 150));
        add(new Wall(380, 180, 15, 150));
        add(new Wall(200, 160, 180, 15));
        //初始化墙

    }

    public static GameModel getInstance(){
        return gameModel;
    }

    public void add(GameObject object){
        this.gameObjects.add(object);
    }
    public void remove(GameObject object){
        this.gameObjects.remove(object);
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
