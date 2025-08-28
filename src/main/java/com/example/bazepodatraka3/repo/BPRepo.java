package com.example.bazepodatraka3.repo;

import java.util.List;

public interface BPRepo<T, Id> {
    List<T> findAll();
    void save(T entity);
    void deleteById(Id id);
    void update(Id oldEntityId, T newEntity);
}
