package com.orderthread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName() + "ft�߳�");
		//ֹͣ3��
		TimeUnit.SECONDS.sleep(3);
		//�첽�߳�
		
		return 200;
	}
}
