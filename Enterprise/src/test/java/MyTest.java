import com.color.dao.UserDao;
import com.color.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author yd
 * @version 1.0
 * @date 2021/4/14 14:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MyTest {
    @Resource
    UserDao userDao;

    @Test
    public void getTest(){
        String username="tioxy";
        UserInfo userInfo = userDao.queryUserByUsername(username);
        System.out.println(userInfo);
    }
}
