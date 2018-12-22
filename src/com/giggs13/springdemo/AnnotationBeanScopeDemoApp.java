package com.giggs13.springdemo;

import com.giggs13.springdemo.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = applicationContext.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = applicationContext.getBean("tennisCoach", Coach.class);

        boolean result = (theCoach == alphaCoach);
        System.out.println("\nPointing to the same object: " + result);
        System.out.println("Memory location for theCoach: " + theCoach);
        System.out.println("Memory location for alphaCoach: " + alphaCoach);

        applicationContext.close();
    }
}
