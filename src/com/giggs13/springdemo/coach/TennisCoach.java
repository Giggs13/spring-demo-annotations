package com.giggs13.springdemo.coach;

import com.giggs13.springdemo.fortune.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;
    // private String crazyStuff;

    public TennisCoach() {
        System.out.println(">>> TennisCoach: inside a default constructor");
    }

    @PostConstruct
    private void init() {
        System.out.println(">>> TennisCoach: inside a init()");
    }

    @PreDestroy
    private void destroy() {
        System.out.println(">>> TennisCoach: inside a destroy()");
    }

    /*@Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">>> TennisCoach: inside a setFortuneService() method");
        this.fortuneService = fortuneService;
    }*/

    /*@Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println(">>> TennisCoach: inside a doSomeCrazyStuff() method");
        this.fortuneService = fortuneService;
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
