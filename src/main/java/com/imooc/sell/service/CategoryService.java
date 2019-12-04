package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author panshao
 */
public interface CategoryService  {

    /**
     * 传入类目id，返回对应id的类目
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有的类目并返回
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 通过传入类目编号表，返回对应编号的类目表。若编号不存在则返回空值
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 将传入的类目对象储存到数据库
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
