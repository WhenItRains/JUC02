package com.executors;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ExecutorsS {

	public static void main(String[] args) {

		//ExecutorService es = Executors.newFixedThreadPool(5); 设置几个
		//ExecutorService es = Executors.newSingleThreadExecutor(); 一个
		ExecutorService es = Executors.newCachedThreadPool();  //自动配置
		
		Future<Integer> retur = null;
		
		try {
			for(int i = 1; i <= 60; i++) {
				retur = es.submit(() ->{
					System.out.print(Thread.currentThread().getName() +"\t");
					return new Random().nextInt(5);
				});
				System.out.println(retur.get() +"***************");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			es.shutdown();
		}
	}

}
