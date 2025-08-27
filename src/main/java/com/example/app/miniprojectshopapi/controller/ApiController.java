package com.example.app.miniprojectshopapi.controller;

import org.springframework.web.bind.annotation.*;
import com.example.app.miniprojectshopapi.service.ProductService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ProductService productService;
    public ApiController(ProductService productService){ this.productService = productService; }

    @GetMapping("/productList")
    public List<Map<String,Object>> productList(){
        return productService.listAll();
    }

    @GetMapping("/productDetail/{id}")
    public Map<String,Object> productDetail(@PathVariable Integer id){
        return productService.detail(id);
    }

    @PostMapping("/productInsert")
    public Map<String,Object> insertProduct(@RequestBody Map<String,Object> body){
        // 간단 예시: body에서 필요한 값 꺼내 Product 생성 후 insert
        return java.util.Collections.singletonMap("result","ok");
    }
}
