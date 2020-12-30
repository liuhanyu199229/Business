package com.formssi.third.config;

/**
 * @author kaigenihao
 * @date 2020-06-17 16:09
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 */
@Configuration
@EnableAsync//开启异步调用
public class ThreadExecutorConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /** 核心线程数 */
    private int corePoolSize = Runtime.getRuntime().availableProcessors() + 1;
    /** 最大线程数 */
    private int maxPoolSize = 50;
    /** 队列数 */
    private int queueCapacity = 500;

    @Bean
    public ExecutorService taskExecutor(){
        logger.info("start executor taskExecutor ");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 执行初始化
        executor.initialize();
        return executor.getThreadPoolExecutor();
    }
}