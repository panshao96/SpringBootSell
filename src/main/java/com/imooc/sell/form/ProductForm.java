package com.imooc.sell.form;

import com.imooc.sell.enums.InfoStatusEnum;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductForm {

    /** 商品id */
    private String infoId;

    /** 商品名 */
    private String infoName;

    /** 商品价格 */
    private BigDecimal infoPrice;

    /** 商品库存 */
    private Integer infoStock;

    /** 商品描述 */
    private String infoDescription;

    /** 商品图 */
    private String infoIcon;

    /** 商品状态（上架or下架） */
    private Integer infoStatus = InfoStatusEnum.UP.getCode();

    /**
     * 类目编号
     * 值唯一。对应热榜，男生最爱，女生最爱，优选等等
     */
    private Integer categoryType;
}

