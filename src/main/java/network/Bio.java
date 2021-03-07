package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bio {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        // 创建一个10个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(;;){
            System.out.println("等待连接。。。");
            // 建立连接
            Socket socket = serverSocket.accept();
            System.out.println("连接建立" + socket);
            executorService.submit(() -> {
                try{
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    byte[] buffer = new byte[100];
                    while(inputStream.read(buffer) != -1){
                        String message = new String(buffer, 0, buffer.length);
                        System.out.println(message);
                        outputStream.write(message.getBytes(StandardCharsets.UTF_8));
                        outputStream.flush();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
    }
}
