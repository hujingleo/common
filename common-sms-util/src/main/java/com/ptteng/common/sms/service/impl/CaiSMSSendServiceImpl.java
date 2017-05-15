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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by arthur on 15/9/17.
 */
public class CaiSMSSendServiceImpl implements SMSSendService {

    protected Log log = LogFactory.getLog(this.getClass());

    private String url;
    private String usr;
    private String passwd;
    private Integer priority;
    private String extsrcid;

    @Override
    public String sendSMS(String mobile, String content) {
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("usr", usr));
            nvps.add(new BasicNameValuePair("pwd", passwd));
            nvps.add(new BasicNameValuePair("mobile", mobile));
            nvps.add(new BasicNameValuePair("sms", content));
            nvps.add(new BasicNameValuePair("extdsrcid", extsrcid));
            nvps.add(new BasicNameValuePair("priority", priority+""));

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "GBK"));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            EntityUtils.toString(entity);
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
        String result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("usr", usr));
            nvps.add(new BasicNameValuePair("pwd", passwd));
            nvps.add(new BasicNameValuePair("mobile", mobile));
            nvps.add(new BasicNameValuePair("sms", params[0]));
            nvps.add(new BasicNameValuePair("extdsrcid", extsrcid));
            nvps.add(new BasicNameValuePair("priority", priority+""));

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "GBK"));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            log.info("result is : "+result);
            log.info(System.currentTimeMillis()+"- return: "+getResponseContent(entity));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return  result;
    }

    @Override
    public String sendSMSByTemplateByMore(String mobile, String template, Map params) {
        return null;
    }

    public static String getResponseContent(HttpEntity responseEntity)  throws Exception {
        byte[] bytes = EntityUtils.toByteArray(responseEntity);
        return new String(bytes, "GBK");
    }

    public String getExtsrcid() {
        return extsrcid;
    }

    public void setExtsrcid(String extsrcid) {
        this.extsrcid = extsrcid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

}

