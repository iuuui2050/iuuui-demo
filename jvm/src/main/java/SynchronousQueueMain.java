import java.util.concurrent.SynchronousQueue;

/**
 * @author iuuui
 * @date 2025/03/16 1733
 */
public class SynchronousQueueMain {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();


        // 生产者线程
        new Thread(() -> {
            try {
                String data = "Message";
                System.out.println("生产前");
                queue.put(data); // 阻塞直到消费者取走
                System.out.println("生产后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 消费者线程
        new Thread(() -> {
            try {
                System.out.println("消费前");
                String data = queue.take(); // 阻塞直到生产者放入数据
                System.out.println("消费后：" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
