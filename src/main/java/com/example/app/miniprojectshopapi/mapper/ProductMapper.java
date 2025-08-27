package com.example.app.miniprojectshopapi.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.example.app.miniprojectshopapi.vo.ProductVO;
import com.example.app.miniprojectshopapi.vo.ImageVO;

@Mapper
public interface ProductMapper {
    List<Map<String,Object>> productList();
    List<Map<String,Object>> productList2();
    Map<String,Object> productDetail(Integer id);
    List<ImageVO> productMainImages(Integer productId);
    int productInsert(ProductVO product);
    int productDelete(Integer id);
}
