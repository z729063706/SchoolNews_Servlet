import com.bean.Teacher;
import com.dao.teacherDao;

public class teacherTest {
    public static void main(String[] args) {
        // Teacher t = new Teacher();
        // t.setName("史册");
        // t.setZhicheng("老师");
        // t.setMainpic("https://tuchuang-8gc21lyy9d16036f-1251529691.ap-shanghai.app.tcloudbase.com/2021/12/10/b14f79e0c30df.png");
        // t.setDetail("史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿 史册嘿嘿");
        // teacherDao.insertTeacher(t);
        teacherDao.getTeacherList();
    }
}
