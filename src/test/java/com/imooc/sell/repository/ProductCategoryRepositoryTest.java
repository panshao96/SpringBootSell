package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository PCrepository;

    @Test
    public void findOneTest() {

        //教程的方法还是repository.findOne();
        //我由于找不到便私自改成了repository.getOne();
        //因此报no session错误
        //新的方法为repository.findById(id).get();
        ProductCategory productCategory = PCrepository.findById(1).get();
        System.out.println(productCategory);
    }


    /**
     * Transactional可将测试数据不保存到数据库中（在事务中是报错才回滚，在测试中是每次回滚）
     */
    @Test
    @Transactional
    public void saveTest() {

//        ProductCategory productCategory = new ProductCategory(5, "女生最爱");
        ProductCategory productCategory = PCrepository.findById(9).get();
        productCategory.setCategoryName("新女生最爱");
        ProductCategory result = PCrepository.save(productCategory);

        Assert.assertEquals(result, productCategory);
    }

    @Test
    public void findByTypeTest() {
        List<Integer> list = Arrays.asList(4,5,6,7);
        List<ProductCategory> result = PCrepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }

}