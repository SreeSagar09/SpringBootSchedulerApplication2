package com.app.schedulers;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppSchedulers {
	
	@Scheduled(fixedDelayString = "5000")
	public void doSchedulerWork1() throws Exception {
		System.out.println("From doSchedulerWork1 method: Timestamp: "+new Date()+", ThreadName: "+Thread.currentThread().getName());
	}
	
	@Scheduled(fixedRateString = "${scheduler.fixed.rate}")
	public void doSchedulerWork2() throws Exception {
		System.out.println("From doSchedulerWork2 method: Timestamp: "+new Date()+", ThreadName: "+Thread.currentThread().getName());
	}
	
	@Scheduled(fixedRateString = "#{2*1000}", initialDelayString = "#{@schedulerValues.getInitialDelay}")
	public void doSchedulerWork3() throws Exception {
		System.out.println("From doSchedulerWork3 method: Timestamp: "+new Date()+", ThreadName: "+Thread.currentThread().getName());
	}
	
	@Scheduled(fixedDelayString = "#{T(java.time.Duration).ofSeconds(1).toMillis()}", initialDelayString = "#{@schedulerValues.getInitialDelay}")
	public void doSchedulerWork4() throws Exception {
		System.out.println("From doSchedulerWork4 method: Timestamp: "+new Date()+", ThreadName: "+Thread.currentThread().getName());
	}
}
