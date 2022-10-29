package com.tfliorko.db_lab_4_jdbctemplate.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DysneyPark {
    private Integer id;
    private String city;
    private String street;
    private Integer max_amount_of_visitors;
}
