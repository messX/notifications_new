package com.messx.notifications.api;

import com.messx.notifications.lib.repository.AbstractBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan(basePackages = "com.messx.notifications")
@SpringBootApplication(scanBasePackages = "com.messx.notifications")
@EnableJpaRepositories(basePackages = "com.messx.notifications")
@EnableAutoConfiguration
@EntityScan(basePackages="com.messx.notifications")
public class ApiApplication {
    public static void main(String[] args) {
//        new SpringApplicationBuilder()
//                .bannerMode(Banner.Mode.CONSOLE)
//                .sources(com.messx.notification.api.ApiApplication.class, ApplicationLoader.class)
//                .run(args);
        SpringApplication.run(ApiApplication.class, args);
    }

}
