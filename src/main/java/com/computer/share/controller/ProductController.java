package com.computer.share.controller;

import com.computer.share.model.ResultResponse;
import com.computer.share.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("all")
    public ResultResponse selectAllProduct(){
        return productService.selectAllProduct();
    }

    @RequestMapping("id/{productId}")
    public ResultResponse selectProductById(@PathVariable Integer productId){
        return productService.selectProductDetailByProductId(productId);
    }

}
