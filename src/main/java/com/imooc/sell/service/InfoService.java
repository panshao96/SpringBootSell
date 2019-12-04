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
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询正上架的商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询某一页的全部商品
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 存储
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);


}
