package io.bio;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 9000;// 监听的端口号

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
    }

    public void init() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("启动服务器....");
            int count = 0;
            while (true) {
                count++;
                Socket client = serverSocket.accept(); // 等待客户端链接
                System.out.println("客户端:"+ InetAddress.getLocalHost()+"已连接到服务器" + "，连接数量：" + count);
                // 一个客户端连接就开户两个线程处理读写
                new Thread(new ServerReadThread(client)).start();
                new Thread(new ServerWriteThread(client)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理读操作的线程
     */
    class ServerReadThread implements Runnable {
        private Socket client;

        public ServerReadThread(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            DataInputStream dis = null;
            try {
                while (true) {
                    // 读取客户端数据
                    dis = new DataInputStream(client.getInputStream());
                    String reciver = dis.readUTF();
                    System.out.println("客户端发过来的内容:" + reciver);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (dis != null) {
                        dis.close();
                    }
                    if (client != null) {
                        client = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 处理写操作的线程
     */
    class ServerWriteThread implements Runnable {
        private Socket client;

        public ServerWriteThread(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            DataOutputStream dos = null;
            BufferedReader br = null;
            try {
                while (true) {
                    dos = new DataOutputStream(client.getOutputStream()); // 向客户端回复信息
                    System.out.print("服务端请输入:\r");

                    br = new BufferedReader(new InputStreamReader(System.in)); // 键盘录入
                    String send = br.readLine();

                    dos.writeUTF(send); // 发送数据
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (dos != null) {
                        dos.close();
                    }
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
