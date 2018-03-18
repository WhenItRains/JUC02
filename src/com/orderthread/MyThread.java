package com.orderthread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName() + "ft线程");
		//停止3秒
		TimeUnit.SECONDS.sleep(3);
		//异步线程
		
		return 200;
	}
}
