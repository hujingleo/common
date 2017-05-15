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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2015/10/14.
 */
public class RYHXSMSSendServiceImpl implements SMSSendService {

    protected Log log = LogFactory.getLog(this.getClass());

    private String url;
    private String action;
    private String account;
    private String password;

    @Override
    public String sendSMS(String mobile, String content) {
        HttpClient httpClient = new DefaultHttpClient();
        try {
            String url = "http://dx.ipyy.net/sms.aspx?account="+account+"&password="+password+"&action=send&mobile="+mobile+"&content="+content;
            HttpGet httpGet = new HttpGet(url);

            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            log.info(System.currentTimeMillis()+"- return: "+getResponseContent(entity));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return  "";
    }

    @Override
    public String sendSMSByTemplate(String mobile, String template, String[] params) {
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost(url);

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            log.info(System.currentTimeMillis()+"- return: "+getResponseContent(entity));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return  "";
    }

    @Override
    public String sendSMSByTemplateByMore(String mobile, String template, Map params) {
        return null;
    }

    public static String getResponseContent(HttpEntity responseEntity)  throws Exception {
        byte[] bytes = EntityUtils.toByteArray(responseEntity);
        return new String(bytes, "GBK");
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}