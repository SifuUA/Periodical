package com.okres.model.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public interface GenericDao<T> extends AutoCloseable {

    void create(T entity) throws SQLException;

    T findById(int id);

    List<T> findAll();

    void update(T entity);

    void delete(int id) throws SQLException;

    void close();
}

