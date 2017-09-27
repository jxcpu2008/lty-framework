package com.lty.app.web.auth.message.handler;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.lty.app.web.auth.util.TaskThreadPool;

public class MessageHandlerHelper {

	private static MessageHandlerHelper instance = null;
	private TaskThreadPool pool;
	
	private MessageHandlerHelper() {
		pool = new TaskThreadPool(10, 50, 0, TimeUnit.SECONDS,
									new LinkedBlockingQueue<Runnable>(), 
									new ThreadPoolExecutor.CallerRunsPolicy());
	}
	
	public static MessageHandlerHelper getInstance() {
		if (instance == null) {
			instance = new MessageHandlerHelper();
		}
		return instance;
	}
	
	public synchronized void addTask(Runnable task) {
		pool.execute(task);
	}
	
	public synchronized boolean remove(Runnable task) {
		return pool.remove(task);
	}

	public synchronized void shutdown() {
		pool.shutdown();
	}

	public int getActiveCount() {
		return pool.getActiveCount();
	}
}
