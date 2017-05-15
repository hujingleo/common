package com.ptteng.common.sms.service.impl;

import com.ptteng.common.sms.service.SMSSendService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liangxj on 2016/8/8.
 * 微网通联短彩信接口文档
 */
public class WwtlSMSSendServiceImpl implements SMSSendService {
    protected Log log = LogFactory.getLog(this.getClass());

    private String url="http://cf.51welink.com/submitdata/Service.asmx/g_Submit";//地址
    private String usr;//账号
    private String passwd;//密码
    private String priority;//企业扩展号
    private String extsrcid;//产品号
    @Override
    public String sendSMS(String mobile, String content) {
        String line, result = "";
        try {
           String url1 = "http://cf.51welink.com/submitdata/Service.asmx/g_Submit";

            URL url = new URL(url1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            System.out.print(" usr  = "+usr);
            String postData = "sname="+usr+"&spwd="+passwd+"&scorpid="+"&sprdid="+extsrcid+"&sdst="+mobile
                    +"&smsg="+java.net.URLEncoder.encode(content,"utf-8");
            System.out.print(" postData  = "+postData);
            log.info(" postData  = "+postData);

            conn.setRequestProperty("Content-Length", "" + postData.length());
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(postData);
            out.flush();
            out.close();

            //获取响应状态
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("connect failed!");
                log.info("connect failed!");
            }
            //获取响应内容体

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            System.out.print(" result = "+result);
            log.info(" result = "+result);
            in.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return result;
    }
    public static String getResponseContent(HttpEntity responseEntity)  throws Exception {
        System.out.println(" responseEntity "+responseEntity);
        byte[] bytes = EntityUtils.toByteArray(responseEntity);
        return new String(bytes, "utf-8");
    }
    @Override
    public String sendSMSByTemplate(String mobile, String template, String[] params) {
        return null;
    }

    @Override
    public String sendSMSByTemplateByMore(String mobile, String template, Map<String, String> params) {
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getExtsrcid() {
        return extsrcid;
    }

    public void setExtsrcid(String extsrcid) {
        this.extsrcid = extsrcid;
    }

    public static void main(String[] args){


        WwtlSMSSendServiceImpl service = new WwtlSMSSendServiceImpl();
        service.setUsr("dl5818cp");
        service.setPasswd("Bd1cN3jV");
        service.setUrl("http://cf.51welink.com/submitdata/Service.asmx/g_Submit");
        service.setExtsrcid("1012818");
        service.setPriority("");
        //service.sendSMS("18817008901", "短信内容【签名】");
        service.sendSMS("15201368252","您的验证码是：9999【5818彩票】");

    }

}
