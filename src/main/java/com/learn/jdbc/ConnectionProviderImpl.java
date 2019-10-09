package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProviderImpl implements ConnectionProvider {

    private ConfigurationProvider configurationProvider;

    public ConnectionProviderImpl() {
        configurationProvider = new ConfigurationProviderImpl();
    }

    @Override
    public Connection getConnection() {
        Connection conn = null;

       /* Properties props = configurationProvider.getCongiguration();

        final String user = props.getProperty("user");
        final String password = props.getProperty("password");
        final String url = props.getProperty("url");*/

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lecture02?useSSL=false&autoReconnect=true","root" , "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }


}