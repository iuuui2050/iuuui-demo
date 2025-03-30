import java.util.concurrent.ConcurrentHashMap;

/**
 * @author iuuui
 * @date 2025/03/22 2037
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("name", "Mr");
        System.out.println(map.get("name"));
        map.put("name", "Ms");
        map.remove("name");
    }

}
