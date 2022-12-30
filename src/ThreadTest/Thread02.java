package ThreadTest;

/**
 * 创建三个窗口卖票
 */

public class Thread02 {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();
        t1.setName("test01");
        t2.setName("test02");
        t3.setName("test03");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window extends Thread{
    private static int ticket=100;

    @Override
    public void run() {
        while(true){
            if(ticket<=0){
                break;
            }
            ticket--;
            System.out.println(getName()+"-"+"还剩："+ticket+"张票");
        }
    }
}
