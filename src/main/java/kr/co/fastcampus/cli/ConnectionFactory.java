package kr.co.fastcampus.cli;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class ConnectionFactory {
//        implements DisposableBean , InitializingBean {
    private String driverClass;
    private String url;
    private String user;
    private String password;
    @Getter private Connection connection = null;

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
//    @Override
    public void init() throws Exception {
        log.info("init " + this.url);
        this.connection = createConnection();
    }

//    @Override
    public void destroy() throws Exception {
        log.info("destroy ");
        if(this.connection != null){
            this.connection.close();
        }
    }


}
