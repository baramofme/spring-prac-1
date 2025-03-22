package kr.co.fastcampus.cli.di;

import kr.co.fastcampus.cli.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        boolean condition = true;
//        B b = new B(condition);
//        A a = new A(b);

//        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
//
//        A a = context.getBean("a", A.class);
//        a.print();

        new A().print();
    }
}
