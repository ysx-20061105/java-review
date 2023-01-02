package nio.channel;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SocketChannelTest {

    @Test
    public void ServerSocketChannel() throws Exception {
        int port=8888;
        ByteBuffer buffer = ByteBuffer.wrap("hello xxx".getBytes());
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        while(true){
            System.out.println("listen .....");
            SocketChannel sc = ssc.accept();
            if(sc==null){
                System.out.println("null");
                Thread.sleep(2000);
            }else{
                System.out.println("Incoming connection from:"+sc.socket().getRemoteSocketAddress());
                buffer.rewind();//指针0
                sc.write(buffer);
                sc.close();
            }
        }
    }
    @Test
    public void socketChannel() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("www.baidu.com", 80));
        socketChannel.isOpen();// 测试 SocketChannel 是否为 open 状态
        socketChannel.isConnected();//测试 SocketChannel 是否已经被连接
        socketChannel.isConnectionPending(); //测试 SocketChannel 是否正在进行连接
        socketChannel.finishConnect(); //校验正在进行套接字连接的 SocketChannel是否已经完成连接
        socketChannel.configureBlocking(false);
//        设置和获取参数
//        socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, Boolean.TRUE).setOption(StandardSocketOptions.TCP_NODELAY, Boolean.TRUE);
//        socketChannel.getOption(StandardSocketOptions.SO_KEEPALIVE);
//        socketChannel.getOption(StandardSocketOptions.SO_RCVBUF);
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        socketChannel.read(byteBuffer);
        socketChannel.close();
        System.out.println("read over");
    }
    @Test
    public void datagramChannel_Send() throws Exception {
        DatagramChannel sendChannel= DatagramChannel.open();
        InetSocketAddress sendAddress= new InetSocketAddress("127.0.0.1", 9999);
        while (true) {
            sendChannel.send(ByteBuffer.wrap("发包".getBytes("UTF-8")), sendAddress);
            System.out.println("发包端发包");
            Thread.sleep(1000);
        }
    }
    @Test
    public void datagramChannel_Receive() throws Exception {
        DatagramChannel receiveChannel= DatagramChannel.open();
        InetSocketAddress receiveAddress= new InetSocketAddress(9999);
        receiveChannel.bind(receiveAddress);
        ByteBuffer receiveBuffer= ByteBuffer.allocate(512);
        while (true) {
            receiveBuffer.clear();
            SocketAddress sendAddress= receiveChannel.receive(receiveBuffer);
            receiveBuffer.flip();
            System.out.print(sendAddress.toString() + " ");
            System.out.println(Charset.forName("UTF-8").decode(receiveBuffer));
        }
    }
}
