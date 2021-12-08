import com.dao.userDao;

public class userTest {
    public static void main(String[] args) {
        // userDao.checkUser("admin", "admin");
        userDao.getDetail(userDao.checkUser("admin", "admin"));
        //userDao.userList(1);
    }
}
