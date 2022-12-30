package exception;

import org.junit.Test;

public class tryCatch {
    @Test
    public void test0(){
        int[] arr=new int[4];
        arr[3]=1;
        try{
            System.out.println(arr[4]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(arr[3]);
        }
    }
    @Test
    public void test01(){
        int num = getNum();
        System.out.println(num);
    }
    public static int getNum(){
        int[] arr=new int[4];
        arr[3]=1;
        arr[2]=2;
        try{
            int num=arr[4];
            return num;
        }catch(ArrayIndexOutOfBoundsException e){
            int num=arr[3];
            return num;
        }finally {
            System.out.println(arr[2]);//程序先执行finally再return
        }
    }
}
