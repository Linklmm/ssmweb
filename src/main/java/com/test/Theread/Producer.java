package com.test.Theread;


import java.util.concurrent.BlockingQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * Description 生产者
 * @author playboy
 * @date 2020-06-18 07:50
 * version 1.0
 */
@Slf4j
public class Producer implements Runnable {
	public volatile boolean canceled = false;

	private BlockingQueue storage;

	public Producer(BlockingQueue storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		int num = 0;
		try {
			while (num < Integer.MAX_VALUE / 2 && !canceled) {
				if (num % 100 == 0) {
					this.storage.put(num);
					log.error("{}是100的倍数，已经放入仓库", num);
				}
				num++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			log.error("生产者停止生产");
		}
	}

}
