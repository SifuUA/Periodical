package com.okres.model.dao.impl;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import javax.sql.DataSource;

public class ConnectionPoolHolder {

    private static volatile DataSource dataSource = null;

    public static DataSource getDataSource() {

        if (null == dataSource) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    String url = ("jdbc:mysql://localhost:3306/periodical?allowPublicKeyRetrieval=true" +
                            "&useSSL=false" +
                            "&characterEncoding=UTF-8" +
                            "&useJDBCCompliantTimezoneShift=true" +
                            "&useLegacyDatetimeCode=false" +
                            "&serverTimezone=UTC");
                    MysqlConnectionPoolDataSource pooledDataSource = new MysqlConnectionPoolDataSource();
                    pooledDataSource.setUrl(url);
                    pooledDataSource.setUser("root");
                    pooledDataSource.setPassword("root");
                    dataSource = pooledDataSource;
                }
            }
        }
        return dataSource;

        /*if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    //ds.setUrl("jdbc:mysql://localhost:3306/periodical");
                    //ds.setUrl("jdbc:mysql://localhost:3306/periodical?useSSL=false&characterEncoding=UTF-8");
                    ds.setUrl("jdbc:mysql://localhost:3306/periodical?allowPublicKeyRetrieval=true" +
                            "&useSSL=false" +
                            "&characterEncoding=UTF-8" +
                            "&useJDBCCompliantTimezoneShift=true" +
                            "&useLegacyDatetimeCode=false" +
                            "&serverTimezone=UTC");
                    //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
                    ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
                    ds.setUsername("root");
                    ds.setPassword("root");
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;*/
    }
}
