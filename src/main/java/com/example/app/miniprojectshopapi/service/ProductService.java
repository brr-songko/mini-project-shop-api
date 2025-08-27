package com.example.app.miniprojectshopapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.app.miniprojectshopapi.mapper.ProductMapper;
import com.example.app.miniprojectshopapi.mapper.ImageMapper;
import com.example.app.miniprojectshopapi.vo.ProductVO;
import com.example.app.miniprojectshopapi.vo.ImageVO;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private final ProductMapper productMapper;
    private final ImageMapper imageMapper;

    public ProductService(ProductMapper productMapper, ImageMapper imageMapper) {
        this.productMapper = productMapper;
        this.imageMapper = imageMapper;
    }

    public List<Map<String,Object>> listAll(){
        return productMapper.productList();
    }

    public Map<String,Object> detail(Integer id){
        return productMapper.productDetail(id);
    }

    @Transactional
    public int addProduct(ProductVO p){
        return productMapper.productInsert(p);
    }

    @Transactional
    public void addImage(ImageVO img){
        imageMapper.insertImage(img);
    }
}