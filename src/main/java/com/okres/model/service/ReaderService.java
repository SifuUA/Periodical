package com.okres.model.service;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.ReaderDao;
import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
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

    public Reader createGuestReader() {
        Reader reader = new Reader();
        reader.setRole(Role.GUEST);
        return reader;
    }

    public List<Reader> getAllreaders() {
        ReaderDao readerDao = daoFactory.createReaderDao();
        return readerDao.findAll();
    }

    public Map<Integer, List<String>> getReaderPayments(int readerId) {
        ReaderDao readerDao = daoFactory.createReaderDao();
        return readerDao.findReaderPayments(readerId);
    }

    public boolean readerIsRegistred(Reader reader) {
        ReaderDao readerDao = daoFactory.createReaderDao();
        Optional<Reader> foundReader = readerDao.findReaderByEmailAndPassword(reader.getEmailAddress(), reader.getPassword());
        return foundReader.isPresent();
    }

    public void createReader(Reader reader) {
        ReaderDao readerDao = daoFactory.createReaderDao();

        try {
            readerDao.create(reader);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, List<String>> getReadersPayments() {
        ReaderDao readerDao = daoFactory.createReaderDao();
        return readerDao.findReadersPayments();
    }
}
