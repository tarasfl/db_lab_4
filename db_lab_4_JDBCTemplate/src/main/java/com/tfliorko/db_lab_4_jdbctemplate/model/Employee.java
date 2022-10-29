package com.tfliorko.db_lab_4_jdbctemplate.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private Integer id;
    private String first_name;
    private String second_name;
    private String type_of_job;
    private Integer attraction_id;
}
