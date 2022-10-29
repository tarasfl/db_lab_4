package com.tfliorko.db_lab_4_jdbctemplate.controller;

import com.tfliorko.db_lab_4_jdbctemplate.model.Attraction;

import java.util.Optional;

public interface AttractionController extends GeneralController <Attraction, Integer>{
    Optional<Attraction> findByName(String name);
}
