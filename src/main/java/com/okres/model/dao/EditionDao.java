package com.okres.model.dao;

import com.okres.model.entity.Edition;
import org.apache.commons.fileupload.FileItem;

public interface EditionDao extends GenericDao<Edition> {
    void putNewEdition(String editionName, String category, int price, FileItem file);
}
