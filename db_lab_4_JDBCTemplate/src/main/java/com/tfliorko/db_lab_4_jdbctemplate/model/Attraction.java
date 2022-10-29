package com.tfliorko.db_lab_4_jdbctemplate.model;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attraction {
    private Integer id;
    private String name;
    private Boolean priority_pass;
    private Integer max_amount_of_visitors;
    private Integer dysney_park_id;
}
