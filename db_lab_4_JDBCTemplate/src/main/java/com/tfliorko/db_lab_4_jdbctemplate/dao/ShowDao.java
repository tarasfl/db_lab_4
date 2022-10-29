package com.tfliorko.db_lab_4_jdbctemplate.dao;

import com.tfliorko.db_lab_4_jdbctemplate.model.Show;
import java.util.Optional;

public interface ShowDao extends GeneralDao<Show, Integer>{
    Optional<Show> findByName(String name);
}
