package com.messx.notification.api;

import core.lib.annotations.LogExecutionTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.messx.notification.*")
public class ApiApplication {
    @LogExecutionTime
    public static void main(String[] args) {
//        new SpringApplicationBuilder()
//                .bannerMode(Banner.Mode.CONSOLE)
//                .sources(com.messx.notification.api.ApiApplication.class, ApplicationLoader.class)
//                .run(args);
        SpringApplication.run(ApiApplication.class, args);
    }

}
