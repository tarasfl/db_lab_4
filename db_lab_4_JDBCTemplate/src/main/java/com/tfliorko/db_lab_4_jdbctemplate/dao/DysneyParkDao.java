package com.tfliorko.db_lab_4_jdbctemplate.dao;

import com.tfliorko.db_lab_4_jdbctemplate.model.DysneyPark;
import java.util.Optional;

public interface DysneyParkDao extends GeneralDao<DysneyPark, Integer> {

    Optional<DysneyPark> findByCity(String city);

    Optional<DysneyPark> findByStreet(String street);
}
