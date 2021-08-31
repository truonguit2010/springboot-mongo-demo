package com.realbizgames.demo.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = "com.realbizgames", exclude = {DataSourceAutoConfiguration.class})
@EnableMongoAuditing
public class Application {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
    }

    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class, args);
        } catch (OutOfMemoryError error) {
            System.exit(1);
        }
    }

}
