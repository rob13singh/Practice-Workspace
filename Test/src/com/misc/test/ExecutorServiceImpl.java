package com.misc.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceImpl {

	public static void main(String[] args) {

		Object o1 = new Object();
		Object o2 = new Object();

		ExecutorService service = Executors.newScheduledThreadPool(2);
		
		Future<?> f1 = service.submit(() -> {
			synchronized(o1) {
				synchronized(o2) {
					System.out.println("Hello");
				}
			}
		});
		
		Future<?> f2 = service.submit(() -> {
			synchronized(o2) {
				synchronized(o1) {
					System.out.println("World");
				}
			}
		});
		
		try {
			f1.get();
			f2.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
