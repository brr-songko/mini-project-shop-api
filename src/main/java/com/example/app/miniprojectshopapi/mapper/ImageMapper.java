package com.example.app.miniprojectshopapi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.app.miniprojectshopapi.vo.ImageVO;
import java.util.Map;

@Mapper
public interface ImageMapper {
    int insertImage(ImageVO image);
    List<ImageVO> imageList(Integer productId);
    int deleteImage(Integer id);
}