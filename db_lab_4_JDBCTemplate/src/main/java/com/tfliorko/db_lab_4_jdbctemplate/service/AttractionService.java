package com.tfliorko.db_lab_4_jdbctemplate.service;

import com.tfliorko.db_lab_4_jdbctemplate.model.Attraction;

import java.util.Optional;

public interface AttractionService extends GeneralService<Attraction, Integer>{
    Optional<Attraction> findByName(String name);
}
