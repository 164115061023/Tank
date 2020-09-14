package com.zl;

/**
 * @Description
 * @Author zl
 * @Date 2020/8/2 16:39
 * @Version 1.0
 */
public class T {

    public static void main(String[] args) throws InterruptedException {


        TankFrame tankFrame = new TankFrame();

        new Thread(()->new Audio("com/zl/audio/war1.wav").loop()).start();
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }

    }

}
