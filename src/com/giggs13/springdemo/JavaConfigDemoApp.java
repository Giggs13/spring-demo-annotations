package com.giggs13.springdemo;

import com.giggs13.springdemo.coach.Coach;
import com.giggs13.springdemo.coach.FootballCoach;
import com.giggs13.springdemo.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Coach tennisCoach = applicationContext.getBean("tennisCoach", Coach.class);
        System.out.println(tennisCoach.getDailyWorkout());
        System.out.println(tennisCoach.getDailyFortune());
        FootballCoach footballCoach = applicationContext.getBean("footballCoach", FootballCoach.class);
        System.out.println(footballCoach.getDailyWorkout());
        System.out.println(footballCoach.getDailyFortune());
        System.out.println(footballCoach.getEmail());
        System.out.println(footballCoach.getTeam());

        applicationContext.close();
    }
}
