package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("안녕 세상아!");

        // conetext.close 하려면 Closable 이 필요해서. 상위 부모 타입으로
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
//        ConnectionFactory factory = (ConnectionFactory) context.getBean(ConnectionFactory.class);
//        Connection connection = factory.getConnection();
//        log.info("" + (connection != null));

//        Lifecycle lifecycle = context.getBean(Lifecycle.class);
//        lifecycle.start();
//        log.info(">> 1: "+ lifecycle.isRunning());
//        // dao.xml 등록된 모든 beans 의 detroy 메소드 실행됨
        context.close();
//        log.info(">> 2: "+ lifecycle.isRunning());

        // Dao dao2 = (Dao) context.getBean("dao");
        // Dao dao = context.getBean("dao", Dao.class);
        // dao.query();
    }
}
