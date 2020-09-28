package com.tcp.getcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("all")
public class GetQRCode {
    public static void getURCodePicture(){
        int width=600;
        int height=600;
        String type="png";
        String content=null;
        System.out.println("请输入你想往二维码里面装的东西：");
        content=new Scanner(System.in).nextLine();
        HashMap hints=new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN,2);
        try{
            BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            Path file= new File("D:\\SpringDemos\\TcpTomcat\\target\\classes\\code.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix,type, (java.nio.file.Path) file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        getURCodePicture();
    }
}
