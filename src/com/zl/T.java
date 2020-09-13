package com.zl;

import com.zl.config.PropertiesManager;
import com.zl.enums.Dir;
import com.zl.enums.Group;
import com.zl.pojo.DefaultTank;
import com.zl.utils.Audio;

/**
 * @Description
 * @Author zl
 * @Date 2020/8/2 16:39
 * @Version 1.0
 */
public class T {

    public static void main(String[] args) throws InterruptedException {

        PropertiesManager propertiesManager = PropertiesManager.getPropertiesManagerInstance();
        /*Frame frame = new Frame();
        frame.setSize(800,600);
        frame.setTitle("tank");

        frame.setResizable(false);//窗口是否可以放缩

        frame.setVisible(true);//窗口是否显示

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });*/

        int tankCount = 0;
        if (propertiesManager.getConfig("initTankCount")!=null){
            tankCount = propertiesManager.getIntConfig("initTankCount");
        }


        TankFrame tankFrame = new TankFrame();
        for (int i = 0; i < tankCount; i++) {
            tankFrame.tankList.add(tankFrame.baseTankGroup.creatTank(i*60, 200, Dir.DOWN, Group.BAD, tankFrame));
        }

        new Thread(()->new Audio("com/zl/audio/war1.wav").loop()).start();
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }

    }

}
