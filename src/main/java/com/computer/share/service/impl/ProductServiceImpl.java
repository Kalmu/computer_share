package com.computer.share.service.impl;

import com.computer.share.dao.ProductMapper;
import com.computer.share.model.ProductDetailVO;
import com.computer.share.model.ProductEntity;
import com.computer.share.model.ResultResponse;
import com.computer.share.model.SystemEnum;
import com.computer.share.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public ResultResponse<List<ProductEntity>> selectAllProduct() {
        return new ResultResponse<>(SystemEnum.SUCCESS.getCode(), SystemEnum.SUCCESS.getMessage(), productMapper.selectAllProduct());
    }

    @Override
    public ResultResponse<ProductDetailVO> selectProductDetailByProductId(Integer productId) {
        Assert.notNull(productId, "产品编号不得为空");
        ProductDetailVO productDetailVO = new ProductDetailVO();
        ProductEntity productEntity = productMapper.selectProductById(productId);
        if(productEntity == null){
            return new ResultResponse<>(SystemEnum.FAIL.getCode(), "该产品编号不存在");
        }

        productDetailVO.setProductEntity(productEntity);
        productDetailVO.setImageEntityList(productMapper.selectImageInfoByProductId(productId));
        return new ResultResponse<>(SystemEnum.SUCCESS.getCode(), SystemEnum.SUCCESS.getMessage(), productDetailVO);
    }
}
