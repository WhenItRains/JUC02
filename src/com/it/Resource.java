package com.it;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

	Lock lock = new ReentrantLock();
	//通知对象
	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();
	Condition c3 = lock.newCondition();
	
	//线程资源
	private int sign = 1;
	
	public void print5(int number){
		lock.lock();
		try {
			//判断
			while(sign != 1) {
					c1.await();
			}
			//操作
			for(int i = 0; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "/t AA /t" + number);
			}
			//改变标记
			sign = 2;
			//通讯
			c2.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void print10(int number){
		lock.lock();
		try {
			//判断
			while(sign != 2) {
					c2.await();
			}
			//操作
			for(int i = 0; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName() + "/t BB /t" + number);
			}
			//改变标记
			sign = 3;
			//通讯
			c3.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void print15(int number){
		lock.lock();
		try {
			//判断
			while(sign != 3) {
					c3.await();
			}
			//操作
			for(int i = 0; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName() + "/t CC /t" + number);
			}
			//改变标记
			sign = 1;
			//通讯
			c1.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
