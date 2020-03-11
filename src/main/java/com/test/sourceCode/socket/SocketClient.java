package com.test.sourceCode.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * Description Socket客户端代码
 * @author playboy
 * @date 2020-03-11 10:18
 * version 1.0
 */
@Slf4j
public class SocketClient {
	private static final Integer SIZE = 1024;
	private static final ThreadPoolExecutor socketPoll = new ThreadPoolExecutor(50, 50,
			365, TimeUnit.DAYS, new LinkedBlockingQueue<>(400));

	/**
	 * 模拟客户端同事向服务器发送6条消息
	 */
	@Test
	public void test() throws InterruptedException {
		for (int i = 0; i < 6; i++) {
			socketPoll.submit(()->{
				send("localhost",7007,"nihao");
			});
			Thread.sleep(100000000);
		}
	}

	public static String send(String domainName, int port, String content) {
		log.info("客户端开始运行");
		Socket socket = null;
		OutputStream outputStream = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		InputStream is = null;
		StringBuffer response = null;
		try {
			if (StringUtils.isBlank(domainName)) {
				return null;
			}
			//无参构造器初始化 Socket，默认底层协议是TCP
			socket = new Socket();
			socket.setReuseAddress(true);
			//客户端准备连接服务器端，设置超时时间10秒
			socket.connect(new InetSocketAddress(domainName, port), 10000);
			log.info("TCPClient 成功和服务端建立连接");
			//准备发送消息给服务端
			outputStream = socket.getOutputStream();
			//设置UTF编码，防止乱码
			byte[] bytes = content.getBytes(Charset.forName("UTF-8"));
			//输出字节码
			segmentWrite(bytes, outputStream);
			//关闭输出
			socket.shutdownOutput();
			log.info("TCPClient 发送内容为{}", content);

			//等待服务端的返回
			socket.setSoTimeout(50000);//50秒还没有得到数据，直接断开连接
			//得到服务端的返回流
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			//从流中读取返回值
			response = segmentRead(br);
			//关闭输入流
			socket.shutdownInput();

			//关闭各种流和套接字
			close(socket, outputStream, isr, br, is);
			log.info("tcpClient 接受到服务端返回的内容:{}", response);
			return response.toString();
		} catch (ConnectException e) {
			log.error("TCPClient-send socket连接失败", e);
			throw new RuntimeException("socket连接失败");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("TCPClient-send unkown error", e);
			throw new RuntimeException("socket连接失败");
		} finally {
			try {
				close(socket, outputStream, isr, br, is);
			} catch (IOException e) {
				log.error("关闭各种流报错，message:{}", e.getMessage());
			}
		}

	}

	/**
	 * 关闭各种流
	 * @param socket
	 * @param outputStream
	 * @param isr
	 * @param br
	 * @param is
	 * @throws IOException
	 */
	public static void close(Socket socket, OutputStream outputStream,
							 InputStreamReader isr, BufferedReader br, InputStream is) throws IOException {
		if (null != socket && !socket.isClosed()) {
			try {
				socket.shutdownOutput();
			} catch (IOException e) {
				log.info("socket output happen exception,message:{}", e.getMessage());
			}
			try {
				socket.shutdownInput();
			} catch (IOException e) {
				log.info("input shutdown is exception,message:{}", e.getMessage());
			}
			try {
				socket.close();
			} catch (IOException e) {
				log.info("close socket is exception, message:{}", e.getMessage());
			}
			if (null != outputStream) {
				try {
					outputStream.close();
				} catch (IOException e) {
					log.info("outputStream close is happen exception");
				}
			}
			if (null != br) {
				br.close();
			}
			if (null != isr) {
				isr.close();
			}
			if (null != is) {
				is.close();
			}
		}
	}

	/**
	 * 分段读
	 * @param br
	 * @return
	 * @throws IOException
	 */
	public static StringBuffer segmentRead(BufferedReader br) throws IOException {
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb;
	}

	/**
	 * 分段写
	 * @param bytes
	 * @param outputStream
	 * @throws IOException
	 */
	public static void segmentWrite(byte[] bytes, OutputStream outputStream) throws IOException {
		int length = bytes.length;
		int start, end = 0;
		for (int i = 0; end != bytes.length; i++) {
			start = i == 0 ? 0 : i * SIZE;
			end = length > SIZE ? start + SIZE : bytes.length;
			length -= SIZE;
			outputStream.write(bytes, start, end - start);
			outputStream.flush();
		}
	}

}
