package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.socket().bind(new InetSocketAddress(9002));
        socketChannel.configureBlocking(false);
        // EpollSelectorProvider
        Selector selector = Selector.open();
        //
        SelectionKey selectionKey = socketChannel.register(selector,SelectionKey.OP_ACCEPT);
        System.out.println("server start");

        while (true) {
            // blocking wait something happen
            selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeySet.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel sc = server.accept();
                    sc.configureBlocking(false);
                    SelectionKey selKey = server.register(selector,SelectionKey.OP_READ);
                    System.out.println("client connect success");
                } else if (key.isReadable()) {
                    SocketChannel server = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len = server.read(byteBuffer);
                    if (len > 0) {
                        System.out.println("accept data :"+new String(byteBuffer.array()));
                    } else if (len == -1){
                        iterator.remove();
                        System.out.println("client destroy connect ");
                    }
                }
                iterator.remove();
            }

        }


    }
}
