package com.imooc.sell.repository;

        import com.imooc.sell.dataobject.ProductInfo;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;

/**
 * @author panshao
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    /**
     * 通过商品状态来查询
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
