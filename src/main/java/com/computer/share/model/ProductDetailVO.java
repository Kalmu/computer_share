package com.computer.share.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDetailVO {
    private ProductEntity productEntity;
    private List<ImageEntity> imageEntityList = new ArrayList<>();
}
