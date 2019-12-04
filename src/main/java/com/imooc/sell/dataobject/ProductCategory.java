package com.imooc.sell.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author panshao
 */
@Data
@Entity
@ToString
@DynamicUpdate
@NoArgsConstructor
public class ProductCategory {

    /** 类目id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /**
     * 类目编号
     * 值唯一，若数据库中存在。那么就会报错
     * */
    private Integer categoryType;

    public ProductCategory(Integer categoryType, String categoryName) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

}
