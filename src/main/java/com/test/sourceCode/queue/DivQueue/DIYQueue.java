package com.test.sourceCode.queue.DivQueue;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

/**
 * Description 自定义队列的实现
 * @author playboy
 * @date 2020-03-04 09:40
 * version 1.0
 */
@Slf4j
public class DIYQueue<T> implements Queue<T> {
	/**
	 * 队列大小
	 */
	private AtomicInteger size = new AtomicInteger(0);
	/**
	 * 队列容量
	 */
	private Integer capacity;
	/**
	 * 放数据锁
	 */
	private ReentrantLock putLock = new ReentrantLock();
	/**
	 * 取数据锁
	 */
	private ReentrantLock takeLock = new ReentrantLock();
	/**
	 * 链表头
	 */
	private volatile Node<T> head;
	/**
	 * 链表尾
	 */
	private volatile Node<T> tail;

	class DIYNode extends Node<T>{

		public DIYNode(T item) {
			super(item);
		}

	}

	public DIYQueue() {
		capacity = Integer.MAX_VALUE;
		head = tail = new DIYNode(null);
	}

	@Override
	public boolean put(T item) throws Exception {
		/**
		 * 禁止空数据
		 */
		if (null == item){
			return false;
		}
		try {
			//获取锁超时打断
			boolean successLock = putLock.tryLock(300, TimeUnit.MILLISECONDS);
			if (!successLock){
				return false;
			}
			//校验队列大小
			if (capacity == size.get()){
				log.info("queue is full");
				return false;
			}
			tail = tail.next = new DIYNode(item);
			size.incrementAndGet();
			return true;
		} catch (InterruptedException e) {
			log.error("tryLock is fail");
			throw new InterruptedException("tryLock is fail");
		}catch (Exception e){
			log.error("queue happen exception");
			throw new Exception("queue happen exception");
		}finally {
			putLock.unlock();
		}

	}

	@Override
	public T take() throws Exception {
		try {
			boolean successLock = takeLock.tryLock(300,TimeUnit.MILLISECONDS);
			if (!successLock){
				throw new Exception("加锁失败");
			}
			/**
			 * 队列已空
			 */
			if (0==size.get()){
				return null;
			}
			//把头节点的下一个元素拿出来
			Node next = head.next;
			//把头结点的值拿出来
			T result = head.item;
			head.item =null;
			head = next;
			size.decrementAndGet();
			return result;

		} catch (InterruptedException e) {
			log.info("tryLock is fail");
			throw new InterruptedException("tryLock is fail");
		}finally {
			takeLock.unlock();
		}
	}

}
