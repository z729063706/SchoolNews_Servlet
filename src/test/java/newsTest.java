import com.bean.News;
import com.dao.newsDao;
import com.util.htmlUtil;
import com.util.nameShorter;

public class newsTest {
    public static void main(String[] args) {
        //insert
        // News news = new News();
        // news.setTitle("qrTest");
        // news.setContent("tttteeesssttt");
        // news.setPic("http://123/casdfvsdfdas");
        // news.setType(1);
        // newsDao.insertNews(news);

        //select
        //newsDao.getNews(1, 5);
        String html =  newsDao.getDetail(1).getContent();
        String text = htmlUtil.convert(html);
        text = nameShorter.getShortString(text, 120);
        System.out.println(text);
    }
}
