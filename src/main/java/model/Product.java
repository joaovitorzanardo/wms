package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Integer productId;
    private String barCode;
    private String name;
    private Brand brand;
    private Double price = 0.0;
    private Integer quantity = 0; 

}
