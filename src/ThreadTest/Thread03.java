package ThreadTest;

/**
 *
 * 使用Runnable接口创建线程类
 *
 * 步骤：
 * 1.创建类实现Runnable接口
 * 2.实现Runnable接口的run()方法，run()方法中写业务代码
 * 3.创建该类实例
 * 4.创建Thread类参数为Runnable实现类
 * 5.调用Thread类实例的start()方法
 *
 */

public class Thread03 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2!=0){
                System.out.println(i);
            }
        }
    }
}
