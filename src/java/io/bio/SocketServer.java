package io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("wait connect");
            Socket socket =   serverSocket.accept();
            System.out.println("connect success");
//            handler(socket);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        handler(socket);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }


    public static void handler(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("read begin");
            // blocking
        int read = socket.getInputStream().read();
        System.out.println("read finish");
        if (read != 1) {
            System.out.println("accept data:"+new String(bytes,0,read));
        }
    }
}
