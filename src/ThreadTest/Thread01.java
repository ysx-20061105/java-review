package ThreadTest;

/**
 *
 * 多线程的创建，方法一：继承于Thread类
 *
 * Thread类的特性：
 * 每个线程都是某个特点Thread对象的run()方法来完成操作的，经常把run()方法的主体称为线程体
 * 通过该Thread对象的start()方法来启动这个线程。
 *
 * 步骤：
 * 1.创建一个类继承Thread类
 * 2.重写父类的run()方法
 * 3.new该类的对象
 * 4.调用该类的start方法
 *
 */

public class Thread01 {
    public static void main(String[] args) {
        test01 t1 = new test01();
        test02 t2 = new test02();
        t1.start();
        t2.start();
    }
}

/**
 * 遍历100以内的偶数
 */
class test01 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(this.getId()+"-"+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class test02 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<50;i++){
            System.out.println(this.getId()+":"+"hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


