package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 返回的商品属性对象
 * @author panshao
 */
@Data
public class InfoVO implements Serializable {

    private static final long serialVersionUID = 7238889848156881196L;

    @JsonProperty("id")
    private String infoId;

    @JsonProperty("name")
    private String infoName;

    @JsonProperty("price")
    private BigDecimal infoPrice;

    @JsonProperty("description")
    private String infoDescription;

    @JsonProperty("icon")
    private String infoIcon;


}
