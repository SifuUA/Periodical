package com.okres.model.service;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author O.Kres
 * @version 1.0
 * @project Periodical
 * @since 1/13/2019
 */
public class PropertyHolder {
    private String result;
    private InputStream inputStream;
    private static Logger logger = Logger.getLogger(PropertyHolder.class);

    public String getPropValues(String propert) throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "sql_query.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                logger.error("property file: " + propFileName + " not found in the classpath");
                throw new FileNotFoundException();
            }
            logger.debug("Target query: " + propert);
            result = prop.getProperty(propert);
        } catch (Exception e) {
            logger.error("Get error while create property: " + e);
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
        return result;
    }
}
