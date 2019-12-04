package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 返回的商品类目对象
 * @author panshao
 */
@Data
public class CategoryVO<T> {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private T categoryFoods;
}
