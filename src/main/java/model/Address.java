package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private Integer addressId;
    private String cep;
    private String city;
    private String uf;
    private String street;
    private String district;
    private Integer number;

}
