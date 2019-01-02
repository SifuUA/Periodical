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
    private ReaderDao readerDao = daoFactory.createReaderDao();

    public Optional<Reader> getReaderByEmailAndPassword(String email, String password) {
        Optional<Reader> result;
        result = readerDao.findReaderByEmailAndPassword(email, password);
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

    public Map<Integer, List<String>> getReaderPayments(int readerId) {
        return readerDao.findReaderPayments(readerId);
    }

    public boolean readerIsRegistred(Reader reader) {
        Optional<Reader> foundReader = readerDao.findReaderByEmailAndPassword(reader.getEmailAddress(), reader.getPassword());
        return foundReader.isPresent();
    }

    public void createReader(Reader reader) {

        try {
            readerDao.create(reader);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, List<String>> getReadersPayments() {
        return readerDao.findReadersPayments();
    }
}
