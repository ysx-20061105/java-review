package nio.selector;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo02 {

    //服务端代码
    @Test
    public void serverDemo() throws Exception {
        //获取服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //切换非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(9999));
        //获取selector选择器
        Selector selector = Selector.open();
        //channel注册到选择器，进行监听
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //轮询
        while(selector.select()>0){
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                if(key.isAcceptable()){
                    //获取连接
                    SocketChannel accept = serverSocketChannel.accept();
                    //切换非阻塞模式
                    accept.configureBlocking(false);
                    //注册
                    accept.register(selector,SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    SocketChannel socketChannel = (SocketChannel)key.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    readBuffer.clear();
                    int length=0;
                    while((length=socketChannel.read(readBuffer))!=-1){
                        readBuffer.flip();
                        System.out.println("received:"+new String(readBuffer.array(),0,length));
                    }
                }
                keyIterator.remove();
            }
        }
    }

    //客户端代码
    @Test
    public void clientDemo() throws Exception {
        //获取通道，绑定主机和端口号
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost",9999));
        //切换到非阻塞模式
        socketChannel.configureBlocking(false);
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //写入buffer数据
        String str="hello server...";
        buffer.clear();
        buffer.put(str.getBytes());
        //模式切换
        buffer.flip();
        //写入通道
        while(buffer.hasRemaining()){
            socketChannel.write(buffer);
        }
        //关闭
        socketChannel.close();
    }

}
