package com.lty.app.web.auth.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskThreadPool extends ThreadPoolExecutor {

	private static final Logger logger = LoggerFactory.getLogger(TaskThreadPool.class);
	
	public TaskThreadPool(int corePoolSize,
							int maximumPoolSize,
							long keepAliveTime,
							TimeUnit unit,
							BlockingQueue<Runnable> workQueue,
							RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
	}
	
	private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		// TODO Auto-generated method stub
		super.afterExecute(r, t);
		
		long endTime = System.currentTimeMillis();
		long taskTime = endTime - startTime.get();
		logger.info(String.format("%s end, time = %dms", r, taskTime));
		logger.info("taskCount = " + 
						this.getTaskCount() + 
						",taskCompleted = " + 
						this.getCompletedTaskCount() +
						",currentThreads = " +
						this.getPoolSize());
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		// TODO Auto-generated method stub
		super.beforeExecute(t, r);
		
		startTime.set(System.currentTimeMillis());
		logger.info(r.toString() + " start");
	}

	@Override
	protected void terminated() {
		// TODO Auto-generated method stub
		super.terminated();
		
		logger.info("TaskThreadPool terminated!");
	}
}
