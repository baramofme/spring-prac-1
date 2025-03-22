package kr.co.fastcampus.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("안녕 세상아!");

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");

        // Dao dao2 = (Dao) context.getBean("dao");
        Dao dao = context.getBean("dao", Dao.class);
        dao.query();
    }
}
