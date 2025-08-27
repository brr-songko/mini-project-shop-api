package com.example.app.miniprojectshopapi.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductVO {
    private Integer id;
    private String productName;
    private Integer productPrice;
    private Integer deliveryPrice;
    private Integer addDeliveryPrice;
    private String tags;
    private Integer outboundDays;
    private Integer sellerId;
    private Integer categoryId;
    private String activeYn;
    private LocalDateTime createdDate;
}
