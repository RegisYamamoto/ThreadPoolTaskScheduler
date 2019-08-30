package com.regis.ThreadPoolTaskScheduler.service;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;

public class Job1 {
	
	private ScheduledFuture<?> job1;

	public void job1(TaskScheduler scheduler) {
		job1 = scheduler.schedule(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println(Thread.currentThread().getName() + " The Task1 executed at " + new Date());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				String cronExp = "0 37 13 * * *";
				return new CronTrigger(cronExp).nextExecutionTime(triggerContext);
			}
		});
	}
	
}