package com.computer.share.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductEntity {
    private Integer productId;
    private Integer groupId;
    private String title;
    private String subTitle;
    private String tips;
    private String apply;
    private BigDecimal monthPay;

    private Integer imageId;
    private String imageUrl;

    private String detail;
    private String recommand;
}
