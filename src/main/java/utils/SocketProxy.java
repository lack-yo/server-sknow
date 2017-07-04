package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/10/28.
 * socket协议的相关实现，网络io
 * tcp/ip 三次握手四次释放的过程
 */
public class SocketProxy {
    Logger logger = LoggerFactory.getLogger(SocketProxy.class);
    //accept,connect

    public void connect() {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 1234);
        } catch (IOException e) {
            logger.error("客户端建立连接失败，错误", e);
        }

        try {
            //客户端输出流
            assert socket != null;
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            //服务端返回流
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.println("hello");
            pw.flush();
            pw.println("end");
            pw.flush();
            String str = br.readLine();
            System.out.println("response:" + str);
            br.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public void accept() {
        try {
            int port = 1234;
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                //开启异步处理
                socketHandle(socket);

            }
        } catch (IOException e) {
            logger.error("服务端开启失败，错误：", e);
        }
    }

    private void socketHandle(final Socket socket) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                    while (true) {
                        String str = br.readLine();
                        System.out.println("server :" + str);
                        if ("end".equals(str)) {
                            break;
                        }
                        pw.println("ok");
                        pw.flush();
                    }

                    br.close();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
