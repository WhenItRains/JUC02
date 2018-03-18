package com.writeread;

import java.util.concurrent.TimeUnit;

public class ThreadWriteRead {

	public static void main(String[] args) {

		// 资源
		Resource resource = new Resource();

		// 写线程
		new Thread(() -> {
			resource.write("write");
		}, "Write").start();
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//读线程
		for(int i = 1; i <= 100; i++) {
			final int temp = i;
			new Thread(() -> { resource.read(temp); }, "Read").start();
		}
	}

}
