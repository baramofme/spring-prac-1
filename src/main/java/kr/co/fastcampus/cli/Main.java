package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("안녕 세상아!");

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
//        Dao dao2 = (Dao) context.getBean("dao");
//        Dao dao = context.getBean("dao", Dao.class);
//        dao.query();

        ConnectionFactory factory = (ConnectionFactory) context.getBean(ConnectionFactory.class);
        Connection connection = factory.getConnection();
        log.info("" + (connection != null));
    }
}
