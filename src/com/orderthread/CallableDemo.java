package com.orderthread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*
		FutureTask<Integer> ft = new FutureTask<>(new MyThread());
		new Thread(ft, "FT").start();
		Integer integer = null;
		try {
			integer = ft.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(integer);
		*/
		//�첽�߳�
		FutureTask<Integer> ft = new FutureTask<>(new MyThread());
		//main ���߳�
		new Thread(ft, "�첽�߳�").start();
		new Thread(ft, "�첽�߳�2").start();
		Integer integer = ft.get();
		System.out.println("���߳� ���");
	}

}
