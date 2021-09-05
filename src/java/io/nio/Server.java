package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Server {

    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9001));
        //
        serverSocket.configureBlocking(false);

        while (true) {
            SocketChannel socketChannel = serverSocket.accept();
            //
            if (socketChannel != null) {
                System.out.println("connect success");
                socketChannel.configureBlocking(false);

                channelList.add(socketChannel);
            }
            Iterator<SocketChannel> iterator = channelList.iterator();
            while(iterator.hasNext()) {
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                int len = sc.read(byteBuffer);
                if (len > 0) {
                    System.out.println("accept data :"+new String(byteBuffer.array()));
                } else if (len == -1){
                    iterator.remove();
                    System.out.println("client destroy connect ");
                }
            }



        }

    }
}
