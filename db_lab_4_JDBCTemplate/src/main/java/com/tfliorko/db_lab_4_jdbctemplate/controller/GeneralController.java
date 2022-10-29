package com.tfliorko.db_lab_4_jdbctemplate.controller;

import java.util.List;
import java.util.Optional;

public interface GeneralController <T, ID>{
    List<T> findAll();

    Optional<T> findById(ID id);

    Integer create(T entity);

    Integer update(ID id, T entity);

    Integer delete(ID id);
}
