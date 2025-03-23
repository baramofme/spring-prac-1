package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

@Slf4j
public class A {
    // 멤버 변수에 Autowired
    // 없는 bean 을 참조하려고 할 때, 필수적이지 않게해서 로드 시 오류 없이 넘어가게 함
    @Autowired(required = false)
    @Qualifier("b2")
    // 리로스로는, 빈의 함수 이름을 가지고 로드 가능
    // @Resource(name="appBean2")
    private B b;

    // Aware 인터페이스 대신 applicatioContext 주입도 가능
    @Autowired private ApplicationContext applicationContext;

    @PostConstruct
    void init(){
        log.info("context" + applicationContext);
        log.info(" "+b);
    }


    // @Autowired 없어도 스프링이 생성자 의존성 주입의 경우 자동으로 의존성 주입 해줌
//    @Autowired
//    public A(B b) {
//        this.b = b;
//    }

//    @Autowired
//    public void setB(B b) {
//        this.b = b;
//    }
}


//@Slf4j
//public class A implements ApplicationContextAware {
//
//    private ApplicationContext applicationContext;
//
//    void init(){
//        log.error(">> " + applicationContext);
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//}
