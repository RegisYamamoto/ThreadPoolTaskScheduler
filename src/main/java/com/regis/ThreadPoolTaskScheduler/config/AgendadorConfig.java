package com.regis.ThreadPoolTaskScheduler.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.regis.ThreadPoolTaskScheduler.service.Job1;
import com.regis.ThreadPoolTaskScheduler.service.Job2;

@Configuration
@EnableScheduling
public class AgendadorConfig implements SchedulingConfigurer {

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler(); // Instancia o agendador
		threadPoolTaskScheduler.setPoolSize(10);// Define o pool de threads
		threadPoolTaskScheduler.initialize();
		
		Job1 job1 = new Job1();
		job1.job1(threadPoolTaskScheduler);// Atribua o job1 para o agendador
		
		Job2 job2 = new Job2();
		job2.job2(threadPoolTaskScheduler);// Atribua o job1 para o agendador
	}

}