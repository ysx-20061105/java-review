## 集合

数组存储的特点：

一旦初始化后，其长度就确定啦。  数组一旦定义好，其元素的类型就确定啦。

数组存储的弊端：

1. 一旦初始化后，其长度就不可修改
2. 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，效率不高
3. 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
4. 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求不能满足

集合存储的优点：

解决数组存储数据方面的弊端。

### Collection
用于存储一个一个的对象

常用方法：
1. add()/addAll() 添加数据
2. size() 获取元素个数
3. clear() 清空集合
4. isEmpty() 是否是空集合
5. contains()/containsAll() 是否包含某个元素，或某个集合的元素 对象比较调用对象的equals方法
6. remove()/removeAll() 删除
7. retainAll() 取两个集合的交集
8. toArray() 转成数组
9. iterator() 返回迭代器对象，用于遍历集合

测试使用：[Collection](./CollectionTest.java)

#### List
用于存储有序的、可重复的数据,集合中每个元素都有其对应的顺序索引  “动态”数组

实现类：ArrayList、LinkedList、Vector

ArrayList、LinkedList、Vector三者的异同？

相同点：三个类都实现了List接口，存储数据的特点相同：存储有序的、可重复的数据

不同点：
1. ArrayList：作为List接口的主要实现类；线程不安全，效率高；底层使用Object[] elementData存储
2. Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
3. LinkedList：底层使用双向链表存储；对于频繁的插入、删除操作，使用LinkedList比ArrayList效率高

源码分析

[ArrayList探索](./ArrayListTest.java)

#### Set
用于存储无序的、不可重复的数据

实现类：HashSet、LinkedHashSet、TreeSet

Set集合不允许包含相同的元素，如果试把两个相同的元素加入同一个Set集合中，则添加操作失败

Set判断两个对象是否相同不是使用==运算符，而是根据equals()方法

HashSet：
1. HashSet时Set接口的经典实现
2. HashSet按Hash算法来存储集合中的元素，具有很好的存取、查找、删除性能
3. HashSet的特点：
   1. 不能保证元素的排列顺序
   2. HashSet不是线程安全的
   3. 集合元素可以是null
4. 对于存放Set容器的对象，对应的类一定要重写equals()和hashCode()方法，以实现对象相等规则

TreeSet：
1. TreeSet是SortedSet接口的实现类，TreeSet可以确保集合元素处于排序状态
2. TreeSet底层使用红黑树结构存储数据
3. TreeSet两种排序方法：自然排序和定制排序。默认使用自然排序
   1. 自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.而不是equals()
   2. 定制排序，是使用Comparator类重写compare()方法
    

### Map
用于存储一对(key,value)的数据

实现类：HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
















