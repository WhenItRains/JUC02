package com.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore semaphore = new Semaphore(3);

		for (int i = 1; i <= 6; i++) {
			new Thread(() -> {
				try {
					semaphore.acquire();
					
					System.out.println(Thread.currentThread().getName() + "抢到了");
					TimeUnit.SECONDS.sleep(new Random().nextInt(6));
					System.out.println(Thread.currentThread().getName() + "离开了");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					semaphore.release();
				}
			}, String.valueOf(i)).start();

		}

	}

}
