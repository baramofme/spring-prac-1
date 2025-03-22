package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Dao {

    // 컴파일 타임에 기본 생성자 자동 생성해주고, 컨테이너가 bean 을 기본 생성자로 생성함.
    // 근데 생성자를 이미 정의했다면, 기본 생성자로 만들지 못해서 오류가 남
//    public Dao() {
//
//    }

    public void query() {
        var url = "jdbc:h2:mem:test;MODE=MySQL";

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        try (var connection = DriverManager.getConnection(url, "sa", "");
             var statement = connection.createStatement();) {

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

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
