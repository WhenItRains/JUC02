package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * CountDownLatch c = new CountDownLatch(6);
		 * 
		 * for (int i = 1; i <= 6; i++) { final int temp = i; new Thread(() -> {
		 * 
		 * System.out.println(temp + "同学走了"); c.countDown(); },
		 * "your thread name").start(); } c.await(); System.out.println("班长锁门");
		 */
		
		// 统一6国

		CountDownLatch c = new CountDownLatch(6);

		for (int i = 1; i <= 6; i++) {
			final int temp = i;
			new Thread(() -> {

				System.out.println(Nation.forEachEnum(temp).getNation() + "被灭");
				c.countDown();
			}, "your thread name").start();
		}
		c.await();
		System.out.println("统一全国");
	}

}
