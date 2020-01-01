package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.InfoStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoServiceImplTest {

    @Autowired
    InfoServiceImpl infoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo info = infoService.findOne("123456");
        Assert.assertEquals("123456", info.getInfoId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = infoService.findUpAll();
        Assert.assertEquals(1, productInfoList.size());
    }

    @Test
    public void findAll() throws Exception {
        Pageable pageable = PageRequest.of(0, 2);
        Assert.assertNotEquals(0, infoService.findAll(pageable).getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setInfoId("1234565");
        productInfo.setInfoName("牛肉面");
        productInfo.setInfoPrice(new BigDecimal(10.3));
        productInfo.setInfoStock(200);
        productInfo.setInfoDescription("很好吃的虾");
        productInfo.setInfoIcon("http://xxxxx.jpg");
        productInfo.setInfoStatus(InfoStatusEnum.UP.getCode());
        productInfo.setCategoryType(3);

        ProductInfo result = infoService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void offSale() {
        ProductInfo result = infoService.offSale("1234568");
        Assert.assertEquals(InfoStatusEnum.DOWN, result.getProductStatusEnum());
    }

    @Test
    public void onSale() {
        ProductInfo result = infoService.onSale("1234568");
        Assert.assertEquals(InfoStatusEnum.UP, result.getProductStatusEnum());
    }
}