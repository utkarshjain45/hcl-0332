package com.hcl.library.repository;

import java.util.List;
import java.util.Optional;

interface LibraryRepository <T, ID>{
    void save(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    boolean deleteById(ID id);
}
