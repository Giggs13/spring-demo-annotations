package com.giggs13.springdemo;

import com.giggs13.springdemo.coach.Coach;
import com.giggs13.springdemo.coach.FootballCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

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
