package com.ciclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Demo {

	private static final int NUM = 7;

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(NUM, () -> {
			System.out.println("========集齐神龙");
		});

		for (int i = 1; i <= NUM; i++) {
			final int temp = i;
			new Thread(() -> {
				System.out.println("集齐" + temp + "个龙珠");
				try {
					cb.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}, "your thread name").start();

		}

	}

}
