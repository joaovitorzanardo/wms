package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    private Integer brandId;
    private String name;

    public Brand(String name) {
        this.name = name;
    }

}
