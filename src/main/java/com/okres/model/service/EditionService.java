package com.okres.model.service;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.EditionCategoryDao;
import com.okres.model.dao.EditionDao;
import com.okres.model.entity.Edition;
import com.okres.model.entity.EditionCategory;
import org.apache.commons.fileupload.FileItem;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EditionService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    //TODO:replace arguments on EditionPage obj
    public void inputEditionData(Edition edition, FileItem fileItem) {
        try (EditionDao editionDao = daoFactory.createEditionDao()) {
            editionDao.create(edition, fileItem);//;putNewEdition();
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

    public List<Edition> viewAllEditions(int start, int recordsPerPage) {
        DaoFactory daoFactory = DaoFactory.getInstance();

        try (EditionDao editionDao = daoFactory.createEditionDao()) {

            //int start = i * recordsPerPage - recordsPerPage;
            return editionDao.getLimitOfEditions(start, recordsPerPage);
        }
    }

    public int getNoOfRecords() {
        DaoFactory daoFactory = DaoFactory.getInstance();

        try (EditionDao editionDao = daoFactory.createEditionDao()) {
            return editionDao.getCountOfEditions();}

    }

    public void deleteEditionById(int id) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        EditionDao editionDao = daoFactory.createEditionDao();
        try {
            editionDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Edition, String> getEditionsByCategory() {


        return null;
    }
}
