/**
 * @author iuuui
 * @date 2025/03/16 1853
 */
public class ExceptionDome {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        test2();
    }
    public static void test() throws Exception {
        if (true) {
            throw new Exception("");
        }
    }

    public static void test2() {
        if (true) {
            throw new RuntimeException("");
        }
    }
}
