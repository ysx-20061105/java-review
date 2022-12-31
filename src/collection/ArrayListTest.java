package collection;

import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTest {

    /**
     *
     * 调用ArrayList的空参构造器创建实例list
     *
     */
    @Test
    public void NullParamTest(){
        ArrayList list = new ArrayList();
        /*
            public ArrayList(){this(10);} 默认初始容器大小为10
        */

        //添加10个元素，占满list集合
        for(int i=0;i<10;i++){
            list.add(i);
        } //list.size()=10

        list.add(10);
        /*
            此时list集合占满 ，进入add方法判断 s==elementData.length 为true
            执行 elementData=grow() 扩容
            grow方法：
                1. 判断 oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA 其中 oldCapacity=elementData.length 即 oldCapacity=10
                2. int newCapacity = ArraysSupport.newLength(oldCapacity, minCapacity - oldCapacity,  oldCapacity >> 1  );// minCapacity - oldCapacity: minimum growth  //oldCapacity >> 1: preferred growth
                3. 调用Arrays.copyOf()返回扩容后的数组
            ArraysSupport.newLength()方法：
                1. newLength = Math.max(minGrowth, prefGrowth) + oldLength; minGrowth=minCapacity - oldCapacity ，minCapacity=size+1  prefGrowth=oldCapacity >> 1
                    minGrowth=11-10=1   prefGrowth=10 >> 1=5   newLength = Math.max(1,5)+10=15
                2. newLength - MAX_ARRAY_LENGTH <= 0 ;  MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8; 为true 返回newLength
                3. newLength - MAX_ARRAY_LENGTH>0; 返回 hugeLength(oldLength, minGrowth)

            扩容到原来的1.5倍
         */
    }

    @Test
    public void AllParamTest(){
        ArrayList list = new ArrayList(5);
        /*
            判断 参数 initialCapacity 是否大于0
                1. 小于0的话 抛出错误 IllegalArgumentException
                2. 等于0 使用默认大小 10
                3. 大于0 new Object[initialCapacity]

         */
    }

}
