package com.it;

public class ThreadTest {

	public static void main(String[] args) {

		// ��Դ
		Resource resource = new Resource();

		// �߳�

		new Thread(() -> {

			for (int i = 1; i <= 10; i++) {
				final int temp = i;
				resource.print5(temp);
			}
		}, "A").start();
		new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				final int temp = i;
				resource.print10(temp);
			}
		}, "B").start();
		new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				final int temp = i;
				resource.print15(temp);
			}
		}, "C").start();
	}

}
