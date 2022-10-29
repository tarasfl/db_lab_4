package com.tfliorko.db_lab_4_jdbctemplate.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;

@AllArgsConstructor
@Data
public class Customer {
    private Integer id;
    private String first_name;
    private String second_name;
    private Date birthday;
}
