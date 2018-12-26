package com.okres.model.dao;

import com.okres.model.entity.Reader;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ReaderDao extends GenericDao<Reader> {

    Optional <Reader> findReaderByEmailAndPassword(String email, String Password);

    @Override
    void create(Reader entity) throws SQLException;

    @Override
    Reader findById(int id);

    @Override
    List<Reader> findAll();

    @Override
    void update(Reader entity);

    @Override
    void delete(int id);

    @Override
    void close();

    Map<Integer, List<String>> findRaderPayments();
}
