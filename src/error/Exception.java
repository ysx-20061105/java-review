package error;

import org.junit.Test;

import java.util.Date;

public class Exception {
    @Test
    public void test0(){
        //ArrayIndexOutOfBoundsException
        int[] arr=new int[3];
        System.out.println(arr[3]);
    }
    @Test
    public void test01(){
        //NullPointerException
        String str=null;
        System.out.println(str.charAt(0));
    }
    @Test
    public void test02(){
        //ClassCastException
        Object obj=new Date();
        String str=(String) obj;
    }
}
