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
        Assert.assertEquals("123456", info.getProductId());
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
        productInfo.setProductId("1234565");
        productInfo.setProductName("牛肉面");
        productInfo.setProductPrice(new BigDecimal(10.3));
        productInfo.setProductStock(200);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(InfoStatusEnum.UP.getCode());
        productInfo.setCategoryType(3);

        ProductInfo result = infoService.save(productInfo);
        Assert.assertNotNull(result);
    }
}