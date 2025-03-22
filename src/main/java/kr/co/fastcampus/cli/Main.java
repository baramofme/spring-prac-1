package kr.co.fastcampus.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("안녕 세상아!");

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");

        // Dao dao2 = (Dao) context.getBean("dao");
        Dao dao = context.getBean("dao", Dao.class);
        dao.query();
    }
}
