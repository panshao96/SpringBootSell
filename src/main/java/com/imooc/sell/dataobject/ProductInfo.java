package com.imooc.sell.dataobject;

import com.imooc.sell.enums.InfoStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author panshao
 */
@Data
@Entity
@NoArgsConstructor
public class ProductInfo {

    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus = InfoStatusEnum.UP.getCode();


    private Integer categoryType;

//    private Date createTime;

//    private Date updateTime;

}