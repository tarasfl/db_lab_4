package com.tfliorko.db_lab_4_jdbctemplate.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Show {
    private Integer id;
    private String name;
    private Date date;
    private Integer max_amount_of_visitors;
    private Integer dysney_park_id;
}
