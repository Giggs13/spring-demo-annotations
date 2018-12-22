package com.giggs13.springdemo.config;

import com.giggs13.springdemo.coach.Coach;
import com.giggs13.springdemo.coach.SwimCoach;
import com.giggs13.springdemo.fortune.FortuneService;
import com.giggs13.springdemo.fortune.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.giggs13.springdemo")
@PropertySource("classpath:resources/config.properties")
public class AppConfig {

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
