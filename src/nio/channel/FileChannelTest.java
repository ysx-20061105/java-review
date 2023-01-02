package nio.channel;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel:
 *  方法：
 *      1.read() 从Channel中读数据到Buffer
 *      2.write() 将Buffer中的数据写入Channel
 *      3.long position() 返回此通道的文件位置
 *      4.FileChannel position() 设置此通道的文件位置
 *          如果将位置设置在文件结束符之后，然后试图从文件通道中读取数据，读方法将返回- 1 （文件结束标志）。
 *          如果将位置设置在文件结束符之后，然后向通道中写数据，文件将撑大到当前位置并写入数据。这可能导致“文件空洞”，磁盘上物理文件中写入的数据间有空隙。
 *      5.size() 返回此通道的文件的当前大小
 *      6. truncate() 将此通道的文件截取为给定大小
 *      7.force() 强制将所有对此通道的文件更新写入到存储设备中
 *   通道通信 transferFrom()、transferTo()
 */
public class FileChannelTest {
    //FileChannel 读取数据到buffer中
    @Test
    public void read() throws Exception {
        //创建FileChannel
        RandomAccessFile aFile = new RandomAccessFile("F:\\code\\java\\review\\src\\nio\\channel\\01.txt", "rw");
        FileChannel channel = aFile.getChannel();
        //创建Buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //读取数据到buffer中
        int bytesRead;
        while((bytesRead=channel.read(buf))!=-1){
            System.out.println("读取了："+bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            buf.clear();
        }
        aFile.close();
    }

    //FileChannel 写操作
    @Test
    public void write() throws Exception {
        //打开FileChannel
        RandomAccessFile aFile = new RandomAccessFile("F:\\code\\java\\review\\src\\nio\\channel\\02.txt", "rw");
        FileChannel channel = aFile.getChannel();
        //创建buffer对象
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String newData="data write";
        buf.clear();
        //写入内容
        buf.put(newData.getBytes());
        buf.flip();
        //FileChannel 完成最终实现
        while(buf.hasRemaining()){
            channel.write(buf);
        }
        channel.close();
    }

    @Test
    public void transferFrom() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("F:\\code\\java\\review\\src\\nio\\channel\\02.txt", "rw");
        FileChannel aChannel = aFile.getChannel();
        RandomAccessFile bFile = new RandomAccessFile("F:\\code\\java\\review\\src\\nio\\channel\\03.txt", "rw");
        FileChannel bChannel = bFile.getChannel();
        long position=0;
        long size = aChannel.size();
        bChannel.transferFrom(aChannel,position,size);
        aChannel.close();
        bChannel.close();
    }
    @Test
    public void transferTo() throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("F:\\code\\java\\review\\src\\nio\\channel\\02.txt", "rw");
        FileChannel aChannel = aFile.getChannel();
        RandomAccessFile bFile = new RandomAccessFile("F:\\code\\java\\review\\src\\nio\\channel\\04.txt", "rw");
        FileChannel bChannel = bFile.getChannel();
        long position=0;
        long size = aChannel.size();
        aChannel.transferTo(0,size,bChannel);
        aChannel.close();
        bChannel.close();
    }
}
