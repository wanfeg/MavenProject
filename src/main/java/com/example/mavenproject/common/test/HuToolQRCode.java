package com.example.mavenproject.common.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.*;


/**
 * @author :Aurora
 * @version:
 * @date : 2023/10/26 11:27
 * @desc:
 */
public class HuToolQRCode {

    public static void main(String[] args) {
/*        QrConfig qrConfig = QrConfig.create()
                .setForeColor(Color.BLUE)
                .setBackColor(Color.MAGENTA)
                .setWidth(0)
                .setHeight(0).setMargin(1);
        qrConfig.setErrorCorrection(ErrorCorrectionLevel.H);
        String asciiArt = QrCodeUtil.generateAsAsciiArt("https://hutool.cn/",qrConfig);*/
        //System.out.println("asciiArt = " +"\n" +asciiArt);
//        QrConfig config = new QrConfig(300, 300);
//// 设置边距，既二维码和背景之间的边距
//        config.setMargin(3);
//// 设置前景色，既二维码颜色（青色）
//        config.setForeColor(Color.CYAN.getRGB());
//// 设置背景色（灰色）
//        config.setBackColor(Color.GRAY.getRGB());
//
//// 生成二维码到文件，也可以到流
//        QrCodeUtil.generate("你好，世界！", config, FileUtil.file("e:/qrcode2.jpg"));

        QrCodeUtil.generate(//
                "我是猪大强，我为自己代言！", //二维码内容
                QrConfig.create().setImg("e:/4b7c59ba4242a5eb16d720dd1c422e1b_1.jpg"), //附带logo
                FileUtil.file("e:/头像.jpg")//写出到的文件
        );




    }
}
