package com.tfliorko.db_lab_4_jdbctemplate.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tickets {
    private Integer id;
    private Double price;
    private Boolean priority_pass;
    private Date use_date;
    private Integer dysney_park_id;
    private Integer customer_id;
}
