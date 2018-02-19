package com.computer.share.service;

import com.computer.share.model.ProductDetailVO;
import com.computer.share.model.ProductEntity;
import com.computer.share.model.ResultResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    ResultResponse<List<ProductEntity>> selectAllProduct();

    ResultResponse<ProductDetailVO> selectProductDetailByProductId(Integer productId);

    ResultResponse multipartFileUpload(List<MultipartFile> file);
}
