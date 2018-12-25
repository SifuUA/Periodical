package com.okres.model.dao;

import com.okres.model.entity.Edition;
import org.apache.commons.fileupload.FileItem;

import java.util.List;

public interface EditionDao extends GenericDao<Edition> {
    void putNewEdition(String editionName, int category, int price, FileItem file, String notation);

    @Override
    void create(Edition entity);

    @Override
    Edition findById(int id);

    @Override
    List<Edition> findAll();

    @Override
    void update(Edition entity);

    @Override
    void delete(int id);

    @Override
    void close();
}
