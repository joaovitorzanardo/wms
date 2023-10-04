package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItens {

    private Integer orderItensId;
    private Order order;
    private Product product;
    private Integer quantity;

}
