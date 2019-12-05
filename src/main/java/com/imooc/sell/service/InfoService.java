package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author panshao
 */
public interface InfoService {

    /**
     * 通过id来查询某一条商品
     * @param infoId 商品id
     * @return 对应id的商品
     */
    ProductInfo findOne(String infoId);

    /**
     * 查询正上架的商品列表
     * @return 正上架的所有商品的列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询某一页的全部商品
     * @param pageable 页码
     * @return 对应页码的商品列表
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 存储
     * @param productInfo 商品对象
     * @return 传入的商品对象
     */
    ProductInfo save(ProductInfo productInfo);


}
