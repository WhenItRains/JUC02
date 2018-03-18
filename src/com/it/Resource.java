package com.it;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

	Lock lock = new ReentrantLock();
	//֪ͨ����
	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();
	Condition c3 = lock.newCondition();
	
	//�߳���Դ
	private int sign = 1;
	
	public void print5(int number){
		lock.lock();
		try {
			//�ж�
			while(sign != 1) {
					c1.await();
			}
			//����
			for(int i = 0; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "/t AA /t" + number);
			}
			//�ı���
			sign = 2;
			//ͨѶ
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
			//�ж�
			while(sign != 2) {
					c2.await();
			}
			//����
			for(int i = 0; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName() + "/t BB /t" + number);
			}
			//�ı���
			sign = 3;
			//ͨѶ
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
			//�ж�
			while(sign != 3) {
					c3.await();
			}
			//����
			for(int i = 0; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName() + "/t CC /t" + number);
			}
			//�ı���
			sign = 1;
			//ͨѶ
			c1.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
