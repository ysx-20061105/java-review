package nio.selector;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo01 {
    @Test
    public void test01() throws Exception {
        //创建选择器
        Selector selector = Selector.open();
        //创建channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9999));
        //channel绑定到selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //轮询操作
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
        while(keyIterator.hasNext()){
            SelectionKey key = keyIterator.next();
            if(key.isAcceptable()){
                //TODO
            }else if(key.isConnectable()){
                //TODO
            }else if(key.isReadable()){
                //TODO
            }else if(key.isValid()){
                //TODO
            }else if(key.isWritable()){
                //TODO
            }
            keyIterator.remove();
        }
    }
}
