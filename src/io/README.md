## java io

I/O:input/output 输入输出流

I/O技术是非常实用的技术，用处理设备之间的数据传输。

java程序中，对数据的输入输出操作以 流(stream) 的方式进行。

java.io包下提供了各种各样 流(stream) 类和接口，用以获取不同种类的数据，并通过标准的方法输入或输出数据

### I/O原理
input：读取外存的数据到内存中

output：读取内存中的数据写到外存中

## javaI/O类

### 节点流
[FileInputStream(FileReaderWriterTest.FileInputStreamTest())](./FileReaderWriterTest.java)

[FileOutputStream(FileReaderWriterTest.FileOutputStreamTest())](./FileReaderWriterTest.java)

[FileReader(FileReaderWriterTest.FileReaderTest())](./FileReaderWriterTest.java)

[FileWriter(FileReaderWriterTest.FileWriterTest())](./FileReaderWriterTest.java)

[使用字节流实现对图片的复制(FileReaderWriterTest.copyImage())](./FileReaderWriterTest.java)

### 缓冲流

[BufferedInputStream(BufferIOTest.BufferedInputStreamTest())](./BufferIOTest.java)

[BufferedOutputStream(BufferIOTest.BufferedOutputStreamTest())](./BufferIOTest.java)

[BufferedReader(BufferIOTest.BufferedReader())](./BufferIOTest.java)

[BufferedWriter(BufferIOTest.BufferedWriter())](./BufferIOTest.java)

### 转换流

提供字节流与字符流的转换

InputStreamReader：将一个字节的输入流转换为字符的输入流

OutputStreamWriter：将一个字符的输出流转换为字节的输入流

### 标准输入、输出流
System.in和System.out分别代表了系统标准的输入和输出设备

默认输入设备是：键盘，输出设备是：显示器

System.in的类型是InputStream

System.out的类型是PrintStream，是OutputStream的子类

重定向：通过System类的setIn，setOut方法对默认设备进行改变

### 对象流
用于存储和读取基本类型数据和对象的处理流。它可以把java中的对象写入到数据源中，也可以把对象从数据源还原回来

序列化机制：允许把内存中的java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过网络
将这种二进制流传输到另一个网络节点。






