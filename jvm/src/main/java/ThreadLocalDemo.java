/**
 * @author iuuui
 * @date 2025/03/22 1150
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("Hello");
        System.out.println("content -->> " + local.get());
        local.remove();
    }
}
