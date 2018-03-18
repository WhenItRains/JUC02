package com.work;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyResource {

	private int sign = 1;
	private Lock lock = new ReentrantLock();
	private Condition cSpring = lock.newCondition();
	private Condition cSummer = lock.newCondition();
	private Condition cAutumn = lock.newCondition();
	private Condition cWinter = lock.newCondition();

	public void printSpring() throws Exception {

		lock.lock();
		try {
			// �ж�
			while (sign != 1) {
				cSpring.await();
			}
			// ����
			sign = 2;
			System.out.println(Thread.currentThread().getName() + "\t" + Yeas.forEachYeas(1) + "����");
			// ֪ͨ
			cSummer.signal();
		} finally {
			lock.unlock();
		}
	}

	public void printSummer() throws Exception {

		lock.lock();
		try {
			// �ж�
			while (sign != 2) {
				cSummer.await();
			}
			// ����
			sign = 3;
			System.out.println(Thread.currentThread().getName() + "\t" + Yeas.forEachYeas(2) + "����");
			// ֪ͨ
			cAutumn.signal();
		} finally {
			lock.unlock();
		}
	}

	public void printAutumn() throws Exception {

		lock.lock();
		try {
			// �ж�
			while (sign != 3) {
				cAutumn.await();
			}
			// ����
			sign = 4;
			System.out.println(Thread.currentThread().getName() + "\t" + Yeas.forEachYeas(3) + "����");
			// ֪ͨ
			cWinter.signal();
		} finally {
			lock.unlock();
		}
	}

	public void printWinter() throws Exception {

		lock.lock();
		try {
			// �ж�
			while (sign != 4) {
				cWinter.await();
			}
			// ����
			sign = 1;
			System.out.println(Thread.currentThread().getName() + "\t" + Yeas.forEachYeas(4) + "����");
			// ֪ͨ
			cSpring.signal();
		} finally {
			lock.unlock();
		}
	}
}
