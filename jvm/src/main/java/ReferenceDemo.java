import java.lang.ref.*;

/**
 * @author iuuui
 * @date 2025/03/22 1556
 */
public class ReferenceDemo {

    public static void main(String[] args) {
//        strongReference();
//        softReference();
//        weakReference();
        phantomReference();
    }


    /**
     * JVM options：-Xms15m -Xmx15m
     * 解释：变量 phantomRef 为虚引用，GC发生就会被回收，若被回收会将对象放到队列中
     * 场景：在对象被回收时收到通知，执行资源清理操作
     */
    public static void phantomReference() {
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<byte[]> phantomRef = new PhantomReference<>(new byte[1024 * 1024 * 10], queue); // 10MB
        System.out.println("gc before：" + phantomRef.get()); // gc before：null     【无法通过虚引用获取对象】
        byte[] byte1 = new byte[1024*1024*3]; // 为了触发GC
        // 队列获取被回收的虚引用对象
        Reference<?> phantomObj = queue.poll();
        System.out.println("gc before：" + phantomObj); // gc before：java.lang.ref.PhantomReference@16f65612
    }

    /**
     * JVM options：-Xms15m -Xmx15m
     * 解释：变量 weakRef 为弱引用，发生GC就被回收
     */
    public static void weakReference() {
        WeakReference<byte[]> weakRef = new WeakReference<>(new byte[1024 * 1024 * 10]); // 10MB
        System.out.println("gc before：" + weakRef.get()); // gc before：[B@16f65612
        System.gc();
        System.out.println("gc after：" + weakRef.get()); // gc after：null
    }


    /**
     * JVM options：-Xms15m -Xmx15m
     * 解释：变量 softRef 为软引用，正常GC不会被回收，当内存不足时（OutOfMemory）被回收
     */
    public static void softReference() {
        SoftReference<byte[]> softRef = new SoftReference<>(new byte[1024 * 1024 * 10]); // 10MB
        System.out.println("gc before：" + softRef.get()); // gc before：[B@16f65612
        System.gc();
        System.out.println("normal gc after：" + softRef.get()); // normal gc after：[B@1b6d3586
        try {
            byte[] bigByte = new byte[1024 * 1024 * 20];
        } catch (OutOfMemoryError error) {
            System.err.println("OutOfMemoryError!!!");
        }
        System.out.println("OutOfMemoryError gc after：" + softRef.get()); // gc after：null
    }

    /**
     * JVM options：-Xms15m -Xmx15m
     * 解释：变量 strongRef 为强引用，GC或OOM都不会被回收，两次输出都能正常打印
     */
    public static void strongReference() {
        byte[] strongRef = new byte[1024 * 1024 * 10]; // 10MB
        System.out.println("gc before：" + strongRef); // gc after：[B@1b6d3586
        System.gc(); // 触发GC回收，但并不一定会执行
        System.out.println("gc after"); // gc after：[B@1b6d3586
        try {
            byte[] bigByte = new byte[1024 * 1024 * 20];
        } catch (OutOfMemoryError error) {
            System.err.println("OutOfMemoryError!!!");
        }
        System.out.println("OutOfMemory gc after：" + strongRef); // gc after：[B@1b6d3586
    }

}
