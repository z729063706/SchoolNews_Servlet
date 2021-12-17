import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dao.baiduDao;
import com.util.JsonUtil;
import com.util.httpUtil;

public class baiduTest {
    public static void main(String[] args) {
        String resp =  httpUtil.get("https://openapi.baidu.com/rest/2.0/tongji/report/getData?access_token=121.72cbea2dd93933e29f254c426152929a.Y5VmMgETnXTT7ackVDKJYJ1ypHWXuob-NXR_yWQ.HFNs_g&site_id=17494485&method=overview&start_date=20211215&end_date=20211217&metrics=pv_count,visitor_count,ip_count");
        JSONObject jsonObject = baiduDao.getHm("20211215", "20211216");
        
        System.out.println(resp);
    }
}
// https://openapi.baidu.com/rest/2.0/tongji/report/getData?access_token=xxxxxxxx&site_id=xxxx&method=overview/getTimeTrendRpt&start_date=20190101&end_date=20190105&metrics=pv_count,visitor_count,ip_count


// 登陆 
// http://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id={CLIENT_ID}&redirect_uri={REDIRECT_URI}&scope=basic&display=popup

// 获取access
// http://openapi.baidu.com/oauth/2.0/token?grant_type=authorization_code&code={CODE}&client_id={CLIENT_ID}&client_secret={CLIENT_SECRET}&redirect_uri=oob


// code
// 9f1c744e9fa254d10cd218bd6659b5e4


// refresh
// 122.ac86118bbc44ff35d0186a1ec1f8e53d.YBCjGsZfKByUwnGkrZJixnsjFLco9A_djzmfZWn.QHk3cg

// token
// 121.72cbea2dd93933e29f254c426152929a.Y5VmMgETnXTT7ackVDKJYJ1ypHWXuob-NXR_yWQ.HFNs_g

// API Key：
// wnF31nvMlfoLGecbArQ8rORK
// Secret Key：
// Mkkr9zEGAREemUDr9s12cAfTCIoLmSXH


// site_id
// 17494485