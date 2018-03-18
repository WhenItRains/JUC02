package com.work;

import java.util.concurrent.CountDownLatch;

public class Demo {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * CountDownLatch c = new CountDownLatch(4); for (int i = 1; i <= 4; i++) {
		 * final int temp = i; new Thread(() -> {
		 * System.out.println(Yeas.forEachYeas(temp).getContent() + "����");
		 * c.countDown(); }, "your thread name").start(); } c.await();
		 * 
		 * System.out.println("һ������...");
		 */
		MyResource mr = new MyResource();
		// ����4���߳�
		CountDownLatch c = new CountDownLatch(4);

			new Thread(() -> {
				try {
					mr.printSpring();
					c.countDown();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}, "��").start();
			
			new Thread(() -> {
				try {
					mr.printSummer();
					c.countDown();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}, "��").start();

			new Thread(() -> {
				try {
					mr.printAutumn();
					c.countDown();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}, "��").start();

			new Thread(() -> {
				try {
					mr.printWinter();
					c.countDown();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}, "��").start();
			
			c.await();
			
			System.out.println("һ���ȥ��");

		
	}

}
