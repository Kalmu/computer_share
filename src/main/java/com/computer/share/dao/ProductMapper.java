package com.computer.share.dao;

import com.computer.share.model.ImageEntity;
import com.computer.share.model.ProductEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    
    @Select({"select " ,
            "p.productId," ,
            "p.groupId," ,
            "p.title," ,
            "p.subTitle," ,
            "p.tips," ,
            "p.apply," ,
            "p.monthPay," ,
            "p.imageId," ,
            "img.imageUrl," ,
            "p.detail," ,
            "p.recommand" ,
            " from tb_product p" ,
            " left join tb_image img on p.imageId = img.imageId"})
    List<ProductEntity> selectAllProduct();

    @Select({"select " ,
            "p.productId," ,
            "p.groupId," ,
            "p.title," ,
            "p.subTitle," ,
            "p.tips," ,
            "p.apply," ,
            "p.monthPay," ,
            "p.imageId," ,
            "img.imageUrl," ,
            "p.detail," ,
            "p.recommand" ,
            " from tb_product p" ,
            " left join tb_image img on p.imageId = img.imageId where p.productId = #{productId}"})
    ProductEntity selectProductById(@Param("productId") Integer productId);

    @Select({"select imageId,imageUrl,imageDescribe,productId from tb_image where productId = #{productId}"})
    List<ImageEntity> selectImageInfoByProductId(@Param("productId") Integer productId);
    
}
