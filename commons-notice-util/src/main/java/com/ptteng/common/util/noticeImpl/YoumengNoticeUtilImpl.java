package com.ptteng.common.util.noticeImpl;

import com.ptteng.common.util.notice.NoticeUtil;

import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import sun.swing.StringUIClientPropertyKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;


/**
 * Created by liangxj on 2016/8/12.
 * 说明：安卓和IOS的APPKey和App Master Secret不一样
 */
public class YoumengNoticeUtilImpl implements NoticeUtil{

    private String appkey;
    private String secretKey;
    private String host = "http://msg.umeng.com/api/send";

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }



    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public void pushMessae(String channelId, String title, String message, Integer deviceType, Integer messageType, Integer msgExpires, String custom_content) {

    }

    @Override
    public String pushMessaeForList(String platfrom, String displayType, String type, String deviceTokens, String ticker, String title, String text, String afterOpen, String url, String activity, String custom, String extra, Long start_time, String out_biz_no, String production_mode, Long expire_time, String description) throws IOException {

//
        JSONObject rootJson = new JSONObject();
        if("android".equals(platfrom)){
            System.out.print(" android ");
            JSONObject bodyJson = new JSONObject();
            JSONObject policyJson = new JSONObject();
            JSONObject payloadJson = new JSONObject();
            bodyJson.put("ticker",ticker);
            bodyJson.put("title",title);
            bodyJson.put("text",text);
            bodyJson.put("after_open",afterOpen);
            payloadJson.put("display_type",displayType);
            payloadJson.put("body",bodyJson);
            // payloadJson.put("extra",JSONObject.fromObject(extra));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            if(null != start_time){
                String startTime = simpleDateFormat.format( new Date(start_time));
                policyJson.put("start_time",startTime);
            }
            if(null != expire_time){
                String expireTime = simpleDateFormat.format( new Date(expire_time));
                policyJson.put("expire_time",expireTime);
            }
            policyJson.put("out_biz_no",generateOrderId());
            rootJson.put("payload",payloadJson);
            rootJson.put("policy",policyJson);
            rootJson.put("appkey",appkey);
            rootJson.put("timestamp",System.currentTimeMillis());
            rootJson.put("type",type);
            rootJson.put("device_tokens",deviceTokens);
            rootJson.put("production_mode",production_mode);//生成环境改成true
            rootJson.put("description",description);
            rootJson.put("thirdparty_id",generateOrderId());
        }else{
            System.out.print(" ios ");

            JSONObject payloadJson = new JSONObject();
            JSONObject policyJson = new JSONObject();
            JSONObject apsJson = new JSONObject();
            apsJson.put("alert",text);
            payloadJson.put("aps", apsJson);
//            JSONObject extraJson = JSONObject.fromObject(extra);
//            Set<String> extraKeySet  = extraJson.keySet();
//            for(String key : extraKeySet){
//                payloadJson.put(key,extraJson.get(key));
//            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            if(null != start_time){
                String startTime = simpleDateFormat.format( new Date(start_time));
                policyJson.put("start_time",startTime);
            }
            if(null != expire_time){
                String expireTime = simpleDateFormat.format( new Date(expire_time));
                policyJson.put("expire_time",expireTime);
            }
            rootJson.put("payload",payloadJson);
            rootJson.put("policy",policyJson);
            rootJson.put("appkey",appkey);
            rootJson.put("timestamp",System.currentTimeMillis());
            rootJson.put("type",type);
            rootJson.put("device_tokens",deviceTokens);
            rootJson.put("production_mode",production_mode);//生成环境改成true
            rootJson.put("description",description);
            rootJson.put("thirdparty_id",generateOrderId());
        }

        System.out.println(" json = " + rootJson);
        String url1 = host ;
        String postBody = rootJson.toString();
        String sign = DigestUtils.md5Hex(("POST" + url1 + postBody + secretKey).getBytes("utf8"));
        url1 = url1 + "?sign=" + sign;
        HttpPost post = new HttpPost(url1);
        post.setHeader("User-Agent", "Mozilla/5.0");
        StringEntity se = new StringEntity(postBody, "UTF-8");
        post.setEntity(se);
        // Send the post request and get the response
        HttpResponse response = new DefaultHttpClient().execute(post);
        int status = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + status);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result.toString());
        if (status == 200) {
            System.out.println("Notification sent successfully.");
        } else {
            System.out.println("Failed to send the notification!");
        }

      //  JSONObject resultJson = JSONObject.fromObject(result);
       // System.out.println(result.toString());
        return result.toString();
    }
    public static String generateOrderId() {
        StringBuffer sb = new StringBuffer();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
        String dateString = simpleDateFormat.format(date);
        sb.append(dateString);
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }




    public static void main(String[] args) {

        YoumengNoticeUtilImpl noticeUtil = new YoumengNoticeUtilImpl();

        noticeUtil.setAppkey("5858e4ebf29d9855850004d5");
        noticeUtil.setSecretKey("zih6jbhz48f9nsacstafmzkgo6aoptft");

        try {
            noticeUtil.pushMessaeForList("android","notification","listcast","11111111111111111111111111111111111111111111","消息","安卓测试","你好","go_app","","","",
                    "",null,"","true",1482336000000L,"推送测试-01");
        } catch (IOException e) {

            e.printStackTrace();
        }
        String ss = "{\"cid\":\"1\",\"pid\":\"2\"}";
       // noticeUtil.pushMessae("3810377664273099356","BCC金融","你好3",3,1,86400 * 7,ss);
    }

}
