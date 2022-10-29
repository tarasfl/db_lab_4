package com.tfliorko.db_lab_4_jdbctemplate.dao;

import com.tfliorko.db_lab_4_jdbctemplate.model.Attraction;
import java.util.Optional;

public interface AttractionDao extends GeneralDao<Attraction, Integer> {
    Optional<Attraction> findByName(String name);
}
