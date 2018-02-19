package com.computer.share.model;

import lombok.Data;

@Data
public class ImageEntity {
    private Integer imageId;
    private String imageUrl;
    private String imageDescribe;
    private Integer productId;
}
