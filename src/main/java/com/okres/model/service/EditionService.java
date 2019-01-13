package com.okres.model.service;

import com.okres.model.dao.DaoFactory;
import com.okres.model.dao.EditionCategoryDao;
import com.okres.model.dao.EditionDao;
import com.okres.model.entity.Edition;
import com.okres.model.entity.EditionCategory;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public class EditionService {
    private Logger logger = Logger.getLogger(EditionService.class);

    public void inputEditionData(Edition edition, FileItem fileItem) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        try (EditionDao editionDao = daoFactory.createEditionDao()) {
            editionDao.create(edition, fileItem);
        }
    }

    public List<Edition> getAllEditions() {
        DaoFactory daoFactory = DaoFactory.getInstance();
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

    public int getNoOfRecords() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        try (EditionDao editionDao = daoFactory.createEditionDao()) {
            return editionDao.getCountOfEditions();
        }
    }

    public void deleteEditionById(int id) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        EditionDao editionDao = daoFactory.createEditionDao();
        try {
            editionDao.delete(id);
        } catch (SQLException e) {
            logger.error("Cant delete edition by id: " + e);
        }
    }
}
