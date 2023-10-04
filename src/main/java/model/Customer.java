package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;
    private String phoneNumber;
    private Integer addressId;
    private String fullAddress;

}
