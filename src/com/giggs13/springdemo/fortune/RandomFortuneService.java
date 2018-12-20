package com.giggs13.springdemo.fortune;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    @Value("${property.data}")
    private String[] data;
    private String[] dataPost;
    private Random myRandom = new Random();

    @PostConstruct
    private void init() {
        System.out.println("data: " + Arrays.toString(data));
        System.out.println("dataPost before: " + Arrays.toString(dataPost));
        dataPost = Arrays.copyOf(data, data.length);
        System.out.println("dataPost after: " + Arrays.toString(dataPost));
        System.out.println("Are arrays equal: " + (data == dataPost));
    }

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        return data[index];
    }
}
