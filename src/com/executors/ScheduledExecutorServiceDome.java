package com.executors;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDome {

	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
		ScheduledFuture<Integer> retur = null;
		try {
			for (int i = 1; i <= 60; i++) {
				retur = ses.schedule(() -> {
					System.out.print(Thread.currentThread().getName() + "\t");
					return new Random().nextInt(5);
				}, 2, TimeUnit.SECONDS);
				System.out.println(retur.get() + "***************");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ses.shutdown();
		}

	}

}
