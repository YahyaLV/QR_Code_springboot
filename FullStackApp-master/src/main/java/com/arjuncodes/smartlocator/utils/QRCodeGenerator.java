package com.arjuncodes.smartlocator.utils;

import com.arjuncodes.smartlocator.model.User;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

   
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    public static void generateQRCode(User user) throws WriterException, IOException {
        String qrCodePath = "C:\\Users\\yahya\\Desktop\\qrpfa";
        String qrCodeName = qrCodePath+user.getName()+user.getId()+"-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                 "ID: "+user.getId()+ "\n"+
                         "name: "+user.getName()+ "\n"+
                         "adress: "+user.getAddress(), BarcodeFormat.QR_CODE, 400, 400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }
}