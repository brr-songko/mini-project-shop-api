package com.example.app.miniprojectshopapi.controller;

import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Map;

import com.example.app.miniprojectshopapi.service.ProductService;
import com.example.app.miniprojectshopapi.vo.ImageVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@RestController
public class FileController {
    @Value("${app.upload-dir}")
    private String uploadDir;

    private final ProductService productService;

    public FileController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/upload/{productId}/{type}/{fileName}")
    public Object upload(@PathVariable Integer productId,
                         @PathVariable Integer type,
                         @PathVariable String fileName,
                         @RequestBody Map<String, String> body) {
        String data = body.get("data");
        if (data == null) return java.util.Collections.singletonMap("error", "no data");

        String base64 = data.substring(data.indexOf(";base64,") + 8);
        try {
            File dir = new File(uploadDir, String.valueOf(productId));
            if (!dir.exists()) dir.mkdirs();

            Path outPath = new File(dir, fileName).toPath();
            byte[] decoded = Base64.getDecoder().decode(base64);

            // 기존 FileUtils 대신 Java NIO 사용
            Files.write(outPath, decoded, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            ImageVO img = new ImageVO();
            img.setProductId(productId);
            img.setType(type);
            img.setPath(fileName);
            productService.addImage(img);

            return java.util.Collections.singletonMap("result", "ok");
        } catch (Exception e) {
            e.printStackTrace();
            return java.util.Collections.singletonMap("error", e.getMessage());
        }
    }

    @GetMapping("/download/{productId}/{fileName}")
    public Resource download(@PathVariable String productId, @PathVariable String fileName) throws Exception {
        File f = new File(uploadDir + "/" + productId, fileName);
        if (!f.exists()) throw new RuntimeException("file not found");
        return new FileSystemResource(f);
    }
}
