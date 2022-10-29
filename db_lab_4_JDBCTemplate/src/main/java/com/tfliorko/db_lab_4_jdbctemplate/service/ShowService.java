package com.tfliorko.db_lab_4_jdbctemplate.service;

import com.tfliorko.db_lab_4_jdbctemplate.model.Show;

import java.util.Optional;

public interface ShowService extends GeneralService<Show, Integer> {
    Optional<Show> findByName(String name);
}
