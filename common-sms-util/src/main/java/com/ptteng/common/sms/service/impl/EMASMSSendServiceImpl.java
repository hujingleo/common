package com.ptteng.common.sms.service.impl;

import com.ptteng.common.sms.service.SMSSendService;
import com.ptteng.common.sms.service.util.GetMd5StrUtil;
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
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liangxj on 2016/7/12.
 * 中国短信网
 */
public class EMASMSSendServiceImpl implements SMSSendService {
    protected Log log = LogFactory.getLog(this.getClass());

    private String url;//接口地址
    private String usr;//用户账号
    private String passwd;//用户密码

    private Integer priority;//没用
    private String extsrcid;//子号

    @Override
    public String sendSMS(String mobile, String content) {
        return null;
    }

    @Override
    public String sendSMSByTemplate(String mobile, String template, String[] params) {
        log.info(" params 0 = "+params[0]);
        HttpClient httpClient = new DefaultHttpClient();
        String result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("uid", usr));
            log.info(" pwd = "+passwd);
            System.out.println(" pwd = "+passwd);

            String pwd = GetMd5StrUtil.GetMD5Code(passwd);
            System.out.println(" pwd = "+pwd);
            nvps.add(new BasicNameValuePair("pwd", pwd));
            nvps.add(new BasicNameValuePair("mobile", mobile));
            log.info("  extnum = "+extsrcid);
            nvps.add(new BasicNameValuePair("extnum", extsrcid));

            //param第一个参数是content内容
            nvps.add(new BasicNameValuePair("content",  params[0]));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "GBK"));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            System.out.println("  result = "+result);
            log.info("result is : "+result);
           // log.info(System.currentTimeMillis()+"- return: "+getResponseContent(entity));
        } catch (Exception e) {
            e.printStackTrace();
        }
 finally {
            httpClient.getConnectionManager().shutdown();
        }
        return  result;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getExtsrcid() {
        return extsrcid;
    }

    public void setExtsrcid(String extsrcid) {
        this.extsrcid = extsrcid;
    }

    public static void main(String[] args){
        EMASMSSendServiceImpl service = new EMASMSSendServiceImpl();
        service.setUsr("145228");
        service.setPasswd("dnx228");
        service.setUrl("http://202.85.221.42:9885/c123/sendsms");
        service.setExtsrcid("228");
        service.sendSMSByTemplate("15201368252","81087",new String[]{"【逗你学】短信测试"});
    }
}
