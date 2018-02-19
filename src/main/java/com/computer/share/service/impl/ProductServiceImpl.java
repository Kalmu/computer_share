package com.computer.share.service.impl;

import com.computer.share.ServiceException;
import com.computer.share.dao.ProductMapper;
import com.computer.share.model.ProductDetailVO;
import com.computer.share.model.ProductEntity;
import com.computer.share.model.ResultResponse;
import com.computer.share.model.SystemEnum;
import com.computer.share.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
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
        if (productEntity == null) {
            return new ResultResponse<>(SystemEnum.FAIL.getCode(), "该产品编号不存在");
        }

        productDetailVO.setProductEntity(productEntity);
        productDetailVO.setImageEntityList(productMapper.selectImageInfoByProductId(productId));
        return new ResultResponse<>(SystemEnum.SUCCESS.getCode(), SystemEnum.SUCCESS.getMessage(), productDetailVO);
    }


    @Transactional
    public ResultResponse multipartFileUpload(List<MultipartFile> files) {
        MultipartFile file = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (file.getSize() != 0) {
                StringBuilder picPath = new StringBuilder();
                // TODO 文件路径
                picPath.append(file.getOriginalFilename());
                String picPathStr = picPath.toString();
                log.info("文件路径{}", picPathStr);

                try {
                    //上传文件功能
                    File newFile = new File(picPathStr);
                    if (!newFile.getParentFile().exists()) {
                        if (!newFile.getParentFile().mkdirs()) {
                            throw new ServiceException("创建路径失败");
                        }
                    }
                    //上传文件功能
                    file.transferTo(newFile);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ServiceException("文件上传失败");
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    throw new ServiceException("文件上传失败");
                }

                //插入表

                //插入表结束
            } else {
                return new ResultResponse(SystemEnum.FAIL.getCode(), "上传失败，文件不能为空");
            }

        }
        return new ResultResponse(SystemEnum.SUCCESS.getCode(), SystemEnum.SUCCESS.getMessage());

    }
}