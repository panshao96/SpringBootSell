package com.imooc.sell.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        Assert.assertEquals(new Integer(9), categoryService.findOne(9).getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        Assert.assertNotEquals(0, categoryService.findAll().size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        Assert.assertNotEquals(0, categoryService.findByCategoryTypeIn(Arrays.asList(9,10,11,12)).size());
    }

//    @Test
//    public void save() throws Exception {
//        ProductCategory productCategory = new ProductCategory(10, "男生专享");
//        Assert.assertSame(productCategory, categoryService.save(productCategory));
//
//    }
}