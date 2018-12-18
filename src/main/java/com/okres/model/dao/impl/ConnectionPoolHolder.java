package com.okres.model.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPoolHolder {

    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    //ds.setUrl("jdbc:mysql://localhost:3306/periodical");
                    ds.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=UTF-8");
                    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
                    ds.setUsername("phpmyadmin");
                    ds.setPassword("root");
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);

                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }
}
