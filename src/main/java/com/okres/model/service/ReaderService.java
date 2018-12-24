package com.okres.model.service;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.ReaderDao;
import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;

import java.util.List;
import java.util.Optional;

public class ReaderService {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    ReaderDao readerDao = daoFactory.createReaderDao();

    public Optional<Reader> getReaderByEmailAndPassword(String email, String password) {
        Optional<Reader> result;
        try (ReaderDao readerDao = daoFactory.createReaderDao()) {
            result = readerDao.findReaderByEmailAndPassword(email, password);
        }
        return result;
    }

    public Reader createGuestReader() {
        Reader reader = new Reader();
        reader.setRole(Role.GUEST);
        return reader;
    }

    public List<Reader> getAllreaders() {
        return readerDao.findAll();
    }
}
