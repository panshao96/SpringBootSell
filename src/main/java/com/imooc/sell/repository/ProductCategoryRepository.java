package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author panshao
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 传入类目编号表，返回存在的类目
     * @param categoryTypeList
     * @return
     */
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
