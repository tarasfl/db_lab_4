package com.tfliorko.db_lab_4_jdbctemplate.controller;

import com.tfliorko.db_lab_4_jdbctemplate.model.Show;

import java.util.Optional;

public interface ShowController extends GeneralController <Show, Integer>{
    Optional<Show> findByName(String name);
}
