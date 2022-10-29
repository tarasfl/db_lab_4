package com.tfliorko.db_lab_4_jdbctemplate;

import com.tfliorko.db_lab_4_jdbctemplate.view.MyView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbLab4JdbcTemplateApplication  implements CommandLineRunner{

    @Autowired
    private MyView view;
    public static void main(String[] args) {
        SpringApplication.run(DbLab4JdbcTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        view.show();
    }

}
