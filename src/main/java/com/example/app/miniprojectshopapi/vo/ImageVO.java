package com.example.app.miniprojectshopapi.vo;

import lombok.Data;

@Data
public class ImageVO {
    private Integer id;
    private Integer productId;
    private Integer type;
    private String path;
}