package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * CountDownLatch c = new CountDownLatch(6);
		 * 
		 * for (int i = 1; i <= 6; i++) { final int temp = i; new Thread(() -> {
		 * 
		 * System.out.println(temp + "ͬѧ����"); c.countDown(); },
		 * "your thread name").start(); } c.await(); System.out.println("�೤����");
		 */
		
		// ͳһ6��

		CountDownLatch c = new CountDownLatch(6);

		for (int i = 1; i <= 6; i++) {
			final int temp = i;
			new Thread(() -> {

				System.out.println(Nation.forEachEnum(temp).getNation() + "����");
				c.countDown();
			}, "your thread name").start();
		}
		c.await();
		System.out.println("ͳһȫ��");
	}

}
