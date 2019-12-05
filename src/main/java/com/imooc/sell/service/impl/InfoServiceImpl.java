package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.InfoStatusEnum;
import com.imooc.sell.repository.ProductInfoRepository;
import com.imooc.sell.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author panshao
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String infoId) {
        return repository.findById(infoId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByInfoStatus(InfoStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}