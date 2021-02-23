package com.test.sourceCode.socket;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Description Socket服务器端
 *
 * @author playboy
 * @date 2020-03-11 11:05
 * version 1.0
 */
@Slf4j
public class ScoketServiceStart {
    private static final ThreadPoolExecutor collectPoll = new ThreadPoolExecutor(4, 4,
            365, TimeUnit.DAYS, new LinkedBlockingQueue<>(1));

    /**
     * 启动服务端
     */
    public static final void start() {
        log.info("SocketServiceStart 服务端开始启动");

        try {
            // backlog  serviceSocket处理阻塞时，客户端最大的可创建连接数，超过客户端连接不上
            // 当线程池能力处理满了之后，我们希望尽量阻塞客户端的连接
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress("localhost", 7007));
            log.info("SocketServiceStart 服务端启动成功");
            //自旋，让客户端一直在拉去客户端的请求，如果客户端暂时没有请求，会一直阻塞
            while (true) {
                //接受客户端的请求
                Socket socket = serverSocket.accept();
                //如果队列中有数据了，说明服务端已经到了并发处理的极限了，此时需要返回客户端有意义的信息
                if (collectPoll.getQueue().size() >= 1) {
                    log.info("SocketServiceStart 服务端处理能力到顶，需要控制客户端的请求");
                    //返回处理结果给客户端
                    rejectRequest(socket);
                    continue;
                }
                try {
                    //异步处理客户端提交上来的任务
                    collectPoll.submit(new SocketService(socket));
                } catch (Exception e) {
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回特定的错误码给客户端
     *
     * @param socket
     */
    private static void rejectRequest(Socket socket) throws IOException {
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
            byte[] bytes = "服务器太忙，请稍后重试-".getBytes(Charset.forName("UTF-8"));
            SocketClient.segmentWrite(bytes, outputStream);
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            SocketClient.close(socket, outputStream, null, null, null);
        }
    }

    @Test
    public void test() {
        start();
    }

}
