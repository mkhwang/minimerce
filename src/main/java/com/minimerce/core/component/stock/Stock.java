package com.minimerce.core.component.stock;

import com.minimerce.core.object.deal.type.ProductType;
import lombok.Getter;

/**
 * Created by gemini on 03/06/2017.
 */
@Getter
public class Stock {
    private ProductType type;
    private long optionId;
    private int quantity;

    public Stock(ProductType type, long optionId, int quantity) {
        this.type = type;
        this.optionId = optionId;
        this.quantity = quantity;
    }
}
