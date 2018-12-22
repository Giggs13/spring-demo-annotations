package com.giggs13.springdemo;

import com.giggs13.springdemo.coach.SwimCoach;
import com.giggs13.springdemo.config.AppConfig;
import com.giggs13.springdemo.config.logging.LoggerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(LoggerConfig.class, AppConfig.class);

        SwimCoach coach = applicationContext.getBean("swimCoach", SwimCoach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getEmail());
        System.out.println(coach.getTeam());

        applicationContext.close();
    }
}
