package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository repository;

    @Test
    public void saveTest() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setInfoId("123456");
        productInfo.setInfoName("皮蛋粥");
        productInfo.setInfoPrice(new BigDecimal(3.2));
        productInfo.setInfoStock(100);
        productInfo.setInfoDescription("很好喝的粥");
        productInfo.setInfoIcon("http://xxxxx.jpg");
        productInfo.setInfoStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByInfoStatus() throws Exception{
        Assert.assertNotEquals(0, repository.findByInfoStatus(0).size());
    }
}