package com.messx.notifications.lib.service;

import com.messx.notifications.lib.entity.AbstractBaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IAbstractBaseCrudManager<T extends AbstractBaseEntity, ID extends Serializable> {
    T save(T entity);
    List<T> findAll();
    Optional<T> findById(ID id);
    void delete(T entity);
    void deleteById(ID id);
    T update(T entity);
    T updateById(T entity, ID id);
}
