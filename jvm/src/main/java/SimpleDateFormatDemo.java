import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author iuuui
 * @date 2025/03/22 2152
 */
public class SimpleDateFormatDemo {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
    }

}
