package com.imooc.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author panshao
 */
@Data
@AllArgsConstructor
public class CartDTO {

    private String productId;

    private Integer productQuantity;
}
