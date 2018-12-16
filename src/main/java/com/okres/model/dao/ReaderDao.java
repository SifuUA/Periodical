package com.okres.model.dao;

import com.okres.model.entity.Reader;

import java.util.Optional;

public interface ReaderDao extends GenericDao<Reader> {
    Optional <Reader> findReaderByEmailAndPassword(String email, String Password);
}
