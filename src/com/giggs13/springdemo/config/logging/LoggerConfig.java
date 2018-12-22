package com.giggs13.springdemo.config.logging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Configuration
@PropertySource("classpath:resources/logger.properties")
public class LoggerConfig {

    @Value("${root.logger.level}")
    private String rootLoggerLevel;
    @Value("${printed.logger.level}")
    private String printedLoggerLevel;

    @PostConstruct
    private void init() {
        Level rootLevel = Level.parse(rootLoggerLevel);
        Level printedLevel = Level.parse(printedLoggerLevel);

        Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());

        Logger loggerParent = applicationContextLogger.getParent();
        loggerParent.setLevel(rootLevel);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(printedLevel);
        consoleHandler.setFormatter(new SimpleFormatter());

        loggerParent.addHandler(consoleHandler);
    }
}
