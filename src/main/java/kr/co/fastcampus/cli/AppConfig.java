package kr.co.fastcampus.cli;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    @Qualifier("b1")
    public B appBean1(){
        return new B();
    }
    // @Primary 는 같은 타입의 빈이 있을 때, 무엇을 먼저 주입할 지 모를 때 먼저 주입할 것을 설정
    @Bean
//    @Primary
    @Qualifier("b2")
    public B appBean2(){
        return new B();
    }
}
