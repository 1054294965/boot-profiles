package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Profile({"production","test"})
@Configuration  // 这里用@Component也是可以的，但是定时任务一般属于 配置级，所以用@Configuration比较好
@EnableScheduling   // 2.开启定时任务
public class SchedulePrint {
    //3.添加定时任务
    @Scheduled(cron = "0/2 * * * * ?")
    //或直接指定时间间隔，例如：2秒
    //@Scheduled(fixedRate=2000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
