import com.zuoqiang.dao.UserDao;
import com.zuoqiang.entity.Article;
import com.zuoqiang.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ZUO on 2017/5/29.
 */
public class SpringTest {
    private static ApplicationContext ctx;
    static {
        ctx = new ClassPathXmlApplicationContext(
                "/applicationContext.xml");
    }

    public static void main(String[] args) {
        UserDao userMaper = (UserDao) ctx.getBean("userDao");
        // 测试id=1的用户查询，可根据数据库中的情况修改.
        User user = userMaper.findById(1);
        System.out.println("获取用户 ID=1 的用户名："+user.getName());

        // 得到文章列表测试
        System.out.println("得到用户id为1的所有文章列表:");
        System.out.println("=============================================");
        List<Article> artlist = userMaper.resultUserArticleList(1);
        for (Article article : artlist) {
            System.out.println("title"+article.getTitle());
        }
    }

}
