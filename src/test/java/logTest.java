import com.dao.logDao;

public class logTest {
    public static void main(String[] args) {
        System.out.println(logDao.getLoginCount());
        logDao.getLogs(50);
    }
}
