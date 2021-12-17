package com.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.util.htmlUtil;
import com.util.httpUtil;

public class baiduDao {
    protected static String accToken = "121.72cbea2dd93933e29f254c426152929a.Y5VmMgETnXTT7ackVDKJYJ1ypHWXuob-NXR_yWQ.HFNs_g";
    protected static String site = "17494485";
    public static JSONObject getHm(String sta, String end){
        String url = "https://openapi.baidu.com/rest/2.0/tongji/report/getData?access_token="+accToken+"&site_id="+site+"&method=overview/getTimeTrendRpt&start_date="+sta+"&end_date="+end+"&metrics=pv_count,visitor_count,ip_count";
        return JSON.parseObject(httpUtil.get(url)).getJSONObject("result");
    }
}
