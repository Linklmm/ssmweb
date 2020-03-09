package com.test.sourceCode.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;

/**
 * Description 锁的使用，ArraysBlockingQueue数据结构
 * @author playboy
 * @date 2020-03-09 08:55
 * version 1.0
 */
@Slf4j
public class ConditionDemo {
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	final Object[] items = new Object[100];
	int putptr, takeptr, count;

	public void put(Object x) {
		try {
			lock.lock();
			while (count == items.length) {
				//队列已满，pull等待
				notFull.await();
			}
			items[putptr] = x;
			if (++putptr == items.length){
				putptr = 0;
			}
			++count;
			//队列不为空，唤醒take
			notEmpty.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.info("happen exception,message is :{}",e.getMessage());
		}finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		try {
			lock.lock();
			while (0==count){
				//队列已空，take等待
				notEmpty.await();
			}
			Object x=items[takeptr];
			if (++takeptr == items.length){
				takeptr = 0;
			}
			--count;
			//队列未满，唤醒put
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}

}
