package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Dao2 {
    private Connection connection;

    public Dao2(Connection connection) {
        this.connection = connection;
    }

    public void query() throws SQLException {

             var statement = connection.createStatement();

//            String url = "jdbc:h2:~/test;MODE=MySQL";
            connection.setAutoCommit(false);

            statement.execute("create table member(id int auto_increment,username varchar(255) not null,password varchar(225) not null,primary key(id))");
            try {
                statement.executeUpdate("insert into member(USERNAME , PASSWORD ) values('jihoon', '1234')");
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

            var resultSet = statement.executeQuery("select id, username, password from member");
            while (resultSet.next()) {
                var member = new Member(resultSet);
                log.info(member.toString());
            }
    }
}
