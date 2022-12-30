package collection;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * 常用方法：
 * 1. add()/addAll() 添加数据
 * 2. size() 获取元素个数
 * 3. clear() 清空集合
 * 4. isEmpty() 是否是空集合
 * 5. contains()/containsAll() 是否包含某个元素，或某个集合的元素 对象比较调用对象的equals方法
 * 6. remove()/removeAll() 删除
 * 7. retainAll() 取两个集合的交集
 * 8. toArray() 转成数组
 * 9. iterator() 返回迭代器对象，用于遍历集合
 *
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection test=new ArrayList();
//        1. add()/addAll() 添加数据
        test.add(1);
        test.add(new String("abc"));
        test.add(new Date(2002));
//        2. size() 获取元素个数
        System.out.println("test集合元素的个数："+test.size());
//        3. clear() 清空集合
//        test.clear();
//        4. isEmpty() 是否是空集合
        System.out.println(test.isEmpty());
//        5. contains()/containsAll() 是否包含某个元素，或某个集合的元素 对象比较调用对象的equals方法
        System.out.println(test.contains(new String("abc")));
//        6. remove()/removeAll() 删除
        test.remove(new Date(2002));
//        7. retainAll() 取两个集合的交集
//        8. toArray() 转成数组

//        9. iterator() 返回迭代器对象，用于遍历集合
    }
}
