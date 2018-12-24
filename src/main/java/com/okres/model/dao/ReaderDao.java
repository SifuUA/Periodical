package com.okres.model.dao;

import com.okres.model.entity.Reader;

import java.util.List;
import java.util.Optional;

public interface ReaderDao extends GenericDao<Reader> {
    Optional <Reader> findReaderByEmailAndPassword(String email, String Password);

    @Override
    void create(Reader entity);

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
}
