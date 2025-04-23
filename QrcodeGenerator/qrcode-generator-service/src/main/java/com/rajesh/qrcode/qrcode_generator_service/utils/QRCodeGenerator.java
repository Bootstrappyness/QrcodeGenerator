package com.rajesh.qrcode.qrcode_generator_service.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.*;

import java.io.*;

public class QRCodeGenerator {

    public static byte[] getQRCodeImage(String text, int width, int height) throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", stream);
        return stream.toByteArray();
    }
}

