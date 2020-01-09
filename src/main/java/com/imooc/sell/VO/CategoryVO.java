package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 返回的商品类目对象
 * @author panshao
 */
@Data
public class CategoryVO<T> implements Serializable {

    private static final long serialVersionUID = -2234259945844788225L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private T categoryFoods;
}
