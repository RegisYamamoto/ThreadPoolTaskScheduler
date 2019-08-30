package com.regis.ThreadPoolTaskScheduler.service;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;

public class Job2 {

	private ScheduledFuture<?> job2;
	
	public void job2(TaskScheduler scheduler) {
		job2 = scheduler.schedule(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println(Thread.currentThread().getName() + " ----------- The Task2 executed at ------------ " + new Date());
					try {
						Thread.sleep(1300);
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