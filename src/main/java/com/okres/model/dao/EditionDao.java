package com.okres.model.dao;

import com.okres.model.entity.Edition;
import org.apache.commons.fileupload.FileItem;

import java.sql.SQLException;
import java.util.List;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */

public interface EditionDao extends GenericDao<Edition> {

    @Override
    void create(Edition entity);

    @Override
    Edition findById(int id);

    @Override
    List<Edition> findAll();

    @Override
    void update(Edition entity);

    @Override
    void delete(int id) throws SQLException;

    @Override
    void close();

    void create(Edition entity, FileItem fileItem);

    List<Edition> getLimitOfEditions(int start, int recordsPerPage);

    int getCountOfEditions();
}

