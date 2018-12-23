package com.okres.model.service;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.EditionDao;
import com.okres.model.dao.ReaderDao;
import com.okres.model.entity.Reader;
import com.okres.model.entity.enums.Role;
import org.apache.commons.fileupload.FileItem;

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

    public void inputEditionData(String editionName, String category, int price, FileItem file) {
        EditionDao editionDao = daoFactory.createEditionDao();
        editionDao.putNewEdition(editionName, category, price, file);



    }
}
