package io;

import org.junit.Test;

import java.io.*;

/**
 *
 * 缓冲流的使用
 * 1.缓冲流：
 *  BufferedInputStream
 *  BufferedOutputStream
 *  BufferedReader
 *  BufferedWriter
 *
 * 2.作用：
 *  提供流的读取、写入速度
 *      提高读写速度的原因：内部有一个缓冲区
 *
 */
public class BufferIOTest {

    /**
     * 读取文件内容
     */
    @Test
    public void BufferedInputStreamTest(){
        File file = new File("F:\\code\\java\\review\\src\\io\\hello.txt");
        FileInputStream fis = null;
        BufferedInputStream bis=null;
        try {
            fis = new FileInputStream(file);
            bis=new BufferedInputStream(fis);
            byte[] b=new byte[8];
            int read;
            while((read = bis.read(b))!=-1){
                System.out.print(new String(b,0,read));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 实现图片的复制
     */
    @Test
    public void BufferedOutputStreamTest(){
        File file = new File("F:\\code\\java\\review\\src\\io\\image.png");
        File file1 = new File("F:\\code\\java\\review\\src\\io\\image2.png");
        FileInputStream fis = null;
        FileOutputStream fos=null;
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            fis=new FileInputStream(file);
            fos=new FileOutputStream(file1);
            bis=new BufferedInputStream(fis);
            bos=new BufferedOutputStream(fos);
            byte[] b=new byte[1024];
            int read;
            while((read=bis.read(b))!=-1){
                bos.write(b,0,read);
                bos.flush();//刷新缓冲区
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.close();
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读文件
     */
    @Test
    public void BufferedReaderTest(){
        File file = new File("F:\\code\\java\\review\\src\\io\\hello.txt");
        FileReader fr=null;
        BufferedReader br=null;
        try {
            fr=new FileReader(file);
            br=new BufferedReader(fr);
            int read;
            char[] ch=new char[1024];
            while((read = br.read(ch))!=-1){
                System.out.println(new String(ch,0,read));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现文件的复制
     */
    @Test
    public void BufferedWriterTest(){
        File file = new File("F:\\code\\java\\review\\src\\io\\hello.txt");
        File file1 = new File("F:\\code\\java\\review\\src\\io\\hello2.txt");
        FileReader fr=null;
        FileWriter fw=null;
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            fr=new FileReader(file);
            fw=new FileWriter(file1);
            br=new BufferedReader(fr);
            bw=new BufferedWriter(fw);
            char[] ch=new char[1024];
            int read;
            while((read=br.read(ch))!=-1){
                bw.write(ch,0,read);
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
                fw.close();
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
