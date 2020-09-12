package com.zl;

import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.Bullet;
import com.zl.pojo.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zl
 * @Date 2020/8/2 21:47
 * @Version 1.0
 */
public class TankFrame extends Frame {

    //游戏页面长度和高度
    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    Tank myTank = new Tank(200,400, Dir.DOWN, Group.GOOD, this);

    public List<Bullet> bulletList = new ArrayList<>();
    public List<Tank> tankList = new ArrayList<>();
    public List<Explode> explodeList = new ArrayList<>();
    //public Explode explode = new Explode(100,100,this);

    public TankFrame(){
        //Frame frame = new Frame();
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setTitle("tank");
        setResizable(false);//窗口是否可以放缩
        setVisible(true);//窗口是否显示

        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //消除闪烁
    Image offScreenImage = null;
    Graphics gOffScreen;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
            gOffScreen = offScreenImage.getGraphics();
        }
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.white);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(color);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,this);
    }

    @Override
    public void paint(Graphics g) {

        g.drawString("子弹数量："+bulletList.size(),10,60);
        g.drawString("敌人数量："+tankList.size(),10,80);
        g.drawString("消灭敌人数量："+explodeList.size(),10,100);
        myTank.paint(g);
//        for (Bullet bullet : bulletList) { //这种迭代在过程中不允许删除元素
//            bullet.paint(g);
//        }
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        for (int i = 0; i < tankList.size(); i++) {
            tankList.get(i).paint(g);
        }

        for (int i = 0; i < explodeList.size(); i++) {
            explodeList.get(i).paint(g);
        }

        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tankList.size(); j++) {
                bulletList.get(i).collideWith(tankList.get(j));
            }
        }


        //explode.paint(g);
    }


    class MyKeyListener extends KeyAdapter {
         boolean up = false;
         boolean left = false;
         boolean right = false;
         boolean down = false;
         //键盘被按压
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_UP:
                    up = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                case KeyEvent.VK_DOWN:
                    down = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

         private void setMainTankDir() {
            if(!left && !right && !up && !down){
                myTank.setMoving(false);
            } else{
                myTank.setMoving(true);
                if(left) myTank.setDir(Dir.LEFT);
                if(right) myTank.setDir(Dir.RIGHT);
                if(up) myTank.setDir(Dir.UP);
                if(down) myTank.setDir(Dir.DOWN);
            }
         }

         //键盘按压抬起
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    left = false;
                    break;
                case KeyEvent.VK_UP:
                    up = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = false;
                    break;
                case KeyEvent.VK_DOWN:
                    down = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire(KeyEvent.VK_CONTROL);
                    break;
                case KeyEvent.VK_A:
                    myTank.fire(KeyEvent.VK_A);
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }




    }

}
