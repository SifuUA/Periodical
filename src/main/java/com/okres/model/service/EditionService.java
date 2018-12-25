package com.okres.model.service;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.EditionCategoryDao;
import com.okres.model.dao.EditionDao;
import com.okres.model.entity.Edition;
import com.okres.model.entity.EditionCategory;
import org.apache.commons.fileupload.FileItem;

import java.util.List;

public class EditionService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    //TODO:replace arguments on Edition obj
    public void inputEditionData(String editionName, int category, int price, FileItem file) {
        try (EditionDao editionDao = daoFactory.createEditionDao()) {
            editionDao.putNewEdition(editionName, category, price, file);
        }
    }

    public List<Edition> getAllEditions() {
        try (
                EditionDao editionDao = daoFactory.createEditionDao()) {
            return editionDao.findAll();
        }
    }


    public List<EditionCategory> getAllGategories() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        try (EditionCategoryDao editionCategory = daoFactory.createEditionCategoryDao()) {
            return editionCategory.findAll();
        }
    }
}