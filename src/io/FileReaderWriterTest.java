package io;

import org.junit.Test;

import java.io.*;

/**
 *
 * 流的分类：
 * 1. 操作数据单位：字节流、字符流
 * 2. 数据的流向：输入流、输出流
 * 3. 流的角色：节点流、处理流
 *
 * 流的体系结构：
 *    抽象基类                  节点流
 *       InputStream              FileInputStream
 *       OutputStream             FileOutputStream
 *       Reader                   FileReader
 *       Writer                   FileWriter
 *    缓冲流
 *      BufferedInputStream
 *      BufferedOutputStream
 *      BufferedReader
 *      BufferedWriter
 *
 *
 *
 */

public class FileReaderWriterTest {

    /**
     * 使用FileInputStream将hello.txt文件内容读到内存中，并输出到控制台
     */
    @Test
    public void FileInputStreamTest(){
        File file = new File("F:\\code\\java\\review\\src\\io\\hello.txt");
        FileInputStream fileInputStream=null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] line=new byte[1024];
            int read ;
            while((read=fileInputStream.read(line))!=-1){//当读到文件末尾是返回-1，读到的内容保存到byte数组中
                System.out.println(new String(line,0,read));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用FileOutputStream将数据写入到文件中
     */
    @Test
    public void FileOutputStreamTest(){
        File file = new File("F:\\code\\java\\review\\src\\io\\write.txt");
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream(file,true);//默认覆盖，append：true代表追加写
            String str="FileOutputStream";
            byte[] bytes = str.getBytes();
            fos.write(bytes);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail");
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用FileInputStream将hello.txt文件内容读到内存中，并输出到控制台
     */
    @Test
    public void FileReaderTest(){
        File file = new File("F:\\code\\java\\review\\src\\io\\hello.txt");
        FileReader fr=null;
        try {
            fr=new FileReader(file);
            char[] ch=new char[1024];
            int read;
            while((read=fr.read(ch))!=-1){//当读到文件末尾是返回-1 ，读到的内容保存到char数组
                System.out.println(new String(ch,0,read));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用FileWriter将数据写入到文件中
     */
    @Test
    public void FileWriterTest(){
        File file = new File("F:\\code\\java\\review\\src\\io\\write2.txt");
        FileWriter fw=null;
        try {
            fw=new FileWriter(file);
            fw.write("FileReader");
//            fw.append('A');//该方法不是追加写
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用字节流实现对图片的复制
     */
    @Test
    public void copyImage(){
        File file = new File("F:\\code\\java\\review\\src\\io\\image.png");
        File file1 = new File("F:\\code\\java\\review\\src\\io\\image1.png");
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream(file);
            fos=new FileOutputStream(file1);
            byte[] b=new byte[1024];
            int read;
            while((read=fis.read(b))!=-1){
                fos.write(b,0,read);
            }
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
