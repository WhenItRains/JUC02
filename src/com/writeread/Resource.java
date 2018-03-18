package com.writeread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Resource {

	private Object obj;
	private ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();

	public void write(Object obj) {

		rrw.writeLock().lock();
		try {
			this.obj = obj;
			System.out.println(Thread.currentThread().getName() + "\t" + this.obj);
		} finally {
			rrw.writeLock().unlock();
		}

	}

	public void read(int i) {
		rrw.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t" + this.obj + "\t" + i);
		} finally {
			rrw.readLock().unlock();
		}
	}
}
