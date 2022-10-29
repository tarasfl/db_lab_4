package com.tfliorko.db_lab_4_jdbctemplate.controller;

import com.tfliorko.db_lab_4_jdbctemplate.model.DysneyPark;

import java.util.Optional;

public interface DysneyParkController extends GeneralController <DysneyPark, Integer>{
    Optional<DysneyPark> findByCity(String city);

    Optional<DysneyPark> findByStreet(String street);
}
