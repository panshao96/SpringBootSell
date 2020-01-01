package com.imooc.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.sell.Utils.EnumUtil;
import com.imooc.sell.enums.InfoStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品属性
 * @author panshao
 */
@Data
@Entity
@DynamicUpdate
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductInfo {

    /** 商品id */
    @Id
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

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

    @JsonIgnore
    public InfoStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(infoStatus, InfoStatusEnum.class);
    }

}