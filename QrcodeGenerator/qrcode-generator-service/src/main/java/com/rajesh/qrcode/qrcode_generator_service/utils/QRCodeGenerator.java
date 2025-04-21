package com.rajesh.qrcode.qrcode_generator_service.utils;

public class QRCodeGenerator {

    public static byte[] getQRCodeImage(String text, int width, int height) throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", stream);
        return stream.toByteArray();
    }
}

