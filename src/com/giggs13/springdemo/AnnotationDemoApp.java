package com.giggs13.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach tennisCoach = applicationContext.getBean("tennisCoach", Coach.class);
        System.out.println(tennisCoach.getDailyWorkout());
        Coach footballCoach = applicationContext.getBean("footballCoach", Coach.class);
        System.out.println(footballCoach.getDailyWorkout());

        applicationContext.close();
    }
}
