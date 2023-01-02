package nio.Pipe;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeTest {
    @Test
    public void test() throws Exception {
        //创建管道
        Pipe pipe = Pipe.open();
        //写入管道
            //要向管道写数据，需要访问sink管道
        Pipe.SinkChannel sinkChannel = pipe.sink();
            //通过调用 SinkChannel 的 write()方法，将数据写入 SinkChannel：
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        while(buf.hasRemaining()) {
            sinkChannel.write(buf);
        }
        //从管道读取数据
            //从读取管道的数据，需要访问 source 通道
        Pipe.SourceChannel sourceChannel = pipe.source();
            //调用 source 通道的 read()方法来读取数据：
        ByteBuffer readBuf = ByteBuffer.allocate(48);
        int bytesRead = sourceChannel.read(readBuf);//read()方法返回的 int 值会告诉我们多少字节被读进了缓冲区
    }
}
