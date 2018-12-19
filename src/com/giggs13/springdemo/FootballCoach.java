package com.giggs13.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Kick the ball twenty times";
    }
}
