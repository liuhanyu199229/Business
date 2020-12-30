package com.formssi.third;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 应用启动入口
 * Created by macro on 2018/4/26.
 */
//@EnableSchedulerLock(defaultLockAtMostFor = "PT50S")
@SpringBootApplication
public class MallAdminApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(MallAdminApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(MallAdminApplication.class, args);
    }
}
