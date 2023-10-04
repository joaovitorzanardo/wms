package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Order {

    private Integer orderId;
    private String description;
    private Integer customerId;
    private String customerName;
    private String customerAddress;
    private boolean billed;
    private Date billedDate;

}
