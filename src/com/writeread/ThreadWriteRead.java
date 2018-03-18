package com.writeread;

import java.util.concurrent.TimeUnit;

public class ThreadWriteRead {

	public static void main(String[] args) {

		// ��Դ
		Resource resource = new Resource();

		// д�߳�
		new Thread(() -> {
			resource.write("write");
		}, "Write").start();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���߳�
		for(int i = 1; i <= 100; i++) {
			final int temp = i;
			new Thread(() -> { resource.read(temp); }, "Read").start();
		}
	}

}
