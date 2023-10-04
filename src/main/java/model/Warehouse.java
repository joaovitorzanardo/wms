package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warehouse {

    private Integer warehouseId;
    private Product product;
    private Integer quantity;

}
