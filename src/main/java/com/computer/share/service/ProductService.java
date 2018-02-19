package com.computer.share.service;

import com.computer.share.model.ProductDetailVO;
import com.computer.share.model.ProductEntity;
import com.computer.share.model.ResultResponse;

import java.util.List;

public interface ProductService {

    ResultResponse<List<ProductEntity>> selectAllProduct();

    ResultResponse<ProductDetailVO> selectProductDetailByProductId(Integer productId);
}
