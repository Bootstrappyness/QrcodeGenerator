package com.rajesh.qrcode.qrcode_generator_service.controller;

import com.rajesh.qrcode.qrcode_generator_service.service.QRCodeService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/qrcode")
@CrossOrigin(origins = "*")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping(value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(@RequestBody Map<String, String> request) {
        try {
            String text = request.get("text");
            byte[] qrImage = qrCodeService.generateQRCode(text, 250, 250);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrImage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
