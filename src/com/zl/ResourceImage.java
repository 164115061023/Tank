package com.zl;

import com.zl.utils.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description
 * @Author zl
 * @Date 2020/8/30 11:37
 * @Version 1.0
 */
public class ResourceImage {
    public static BufferedImage goodTankL, goodTankR, goodTankU, goodTankD;
    public static BufferedImage goodTankL2, goodTankR2, goodTankU2, goodTankD2;


    public static BufferedImage badTankL, badTankR, badTankU, badTankD;
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;
    public static BufferedImage[] explodeList = new BufferedImage[16];
    public static BufferedImage[] explodeList2 = new BufferedImage[10];
    static {
        try {
            goodTankU = ImageIO.read(ResourceImage.class.getClassLoader().getResourceAsStream("com/zl/image/goodTankU.png"));
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);
            goodTankU2 = ImageIO.read(ResourceImage.class.getClassLoader().getResourceAsStream("com/zl/image/goodTankU2.png"));
            goodTankR2 = ImageUtil.rotateImage(goodTankU2, 90);
            goodTankL2 = ImageUtil.rotateImage(goodTankU2, -90);
            goodTankD2 = ImageUtil.rotateImage(goodTankU2, 180);

            badTankU = ImageIO.read(ResourceImage.class.getClassLoader().getResourceAsStream("com/zl/image/badTankU.png"));
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);

            bulletD = ImageIO.read(ResourceImage.class.getClassLoader().getResourceAsStream("com/zl/image/bulletD.gif"));
            bulletL = ImageIO.read(ResourceImage.class.getClassLoader().getResourceAsStream("com/zl/image/bulletL.gif"));
            bulletR = ImageIO.read(ResourceImage.class.getClassLoader().getResourceAsStream("com/zl/image/bulletR.gif"));
            bulletU = ImageIO.read(ResourceImage.class.getClassLoader().getResourceAsStream("com/zl/image/bulletU.gif"));

            for (int i = 0; i < 16; i++) {
                explodeList[i] = ImageIO.read(ResourceImage.class.getClassLoader().getResourceAsStream("com/zl/image/e"+ (i+1) +".gif"));
            }

            for (int i = 0; i < 10; i++) {
                explodeList2[i] = ImageIO.read(ResourceImage.class.getClassLoader().getResourceAsStream("com/zl/image/"+ i +".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
