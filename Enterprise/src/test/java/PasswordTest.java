import com.color.util.PasswordUtils;
import org.junit.Test;

/**
 * @author yd
 * @version 1.0
 * @date 2021/4/16 16:07
 */
public class PasswordTest {
    @Test
    public void Test(){
        String password="123";
        System.out.println(PasswordUtils.encodePassword(password));
    }
}
