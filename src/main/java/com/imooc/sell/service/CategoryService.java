package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author panshao
 */
public interface CategoryService  {

    /**
     * 传入类目id，返回对应id的类目
     * @param categoryId 类目id
     * @return 对应id的类目
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 返回所有的类目
     * @return 数据库中所有的类目
     */
    List<ProductCategory> findAll();

    /**
     * 通过传入类目编号表，返回对应编号的类目表。若编号不存在则返回空值
     * @param categoryTypeList 类目编号表
     * @return 对应编号的类目表
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 将传入的类目对象储存到数据库
     * @param productCategory 一个类目对象
     * @return 传入的类目
     */
    ProductCategory save(ProductCategory productCategory);
}
