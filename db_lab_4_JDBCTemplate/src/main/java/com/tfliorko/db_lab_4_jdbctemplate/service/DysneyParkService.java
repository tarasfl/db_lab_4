package com.tfliorko.db_lab_4_jdbctemplate.service;

import com.tfliorko.db_lab_4_jdbctemplate.model.DysneyPark;

import java.util.Optional;

public interface DysneyParkService extends GeneralService<DysneyPark, Integer>{

    Optional<DysneyPark> findByCity(String city);

    Optional<DysneyPark> findByStreet(String street);
}
