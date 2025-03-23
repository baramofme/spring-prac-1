package kr.co.fastcampus.cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String driverClass;
    private String url;
    private String user;
    private String password;

    public ConnectionFactory(String driverClass, String url, String user, String password){
        this.driverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection createConnection() throws SQLException {
//        var url = "jdbc:h2:mem:test;MODE=MySQL";
        try {
            Class.forName(this.driverClass);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        return DriverManager.getConnection(this.url, this.user, this.password);
    }
}
