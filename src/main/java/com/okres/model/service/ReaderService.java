package com.okres.model.service;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.ReaderDao;
import com.okres.model.entity.Reader;

import java.util.Optional;

public class ReaderService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    public Optional<Reader> getReaderByEmailAndPassword(String email, String password) {
        Optional<Reader> result;
        try (ReaderDao readerDao = daoFactory.createReaderDao()) {
            result = readerDao.findReaderByEmailAndPassword(email, password);
        }
        return result;
    }
}
