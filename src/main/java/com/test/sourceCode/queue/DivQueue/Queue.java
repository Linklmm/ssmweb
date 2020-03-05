package com.test.sourceCode.queue.DivQueue;


/**
 * Description 队列接口定义
 * @author playboy
 * @date 2020-03-04 09:35
 * version 1.0
 */
public interface Queue<T> {
	/**
	 * 添加元素
	 * @param item
	 */
	boolean put(T item) throws InterruptedException,Exception;

	/**
	 * 取出元素
	 * @return
	 */
	T take() throws InterruptedException,Exception;

	class Node<T>{
		/**
		 * 节点值
		 */
		T item;

		/**
		 * 下一个元素
		 */
		Node<T> next;

		/**
		 * 构造器
		 * @param item
		 */
		public Node(T item) {
			this.item = item;
		}

	}


}
