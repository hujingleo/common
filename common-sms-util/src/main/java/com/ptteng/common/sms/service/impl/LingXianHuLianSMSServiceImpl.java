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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liangxj on 2016/7/12.
 * 领先互联
 * 账号：jinxincaifu
 密码：jinxincaifu
 */
public class LingXianHuLianSMSServiceImpl implements SMSSendService {
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
            nvps.add(new BasicNameValuePair("CorpID", usr));
            nvps.add(new BasicNameValuePair("Pwd", passwd));
            nvps.add(new BasicNameValuePair("Mobile", mobile));

            //param第一个参数是content内容
            nvps.add(new BasicNameValuePair("Content",  params[0]));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            System.out.println("  result = "+result);
            log.info("result is : " + result);

            String[] resultArr = result.split(",");
            if("03".equals(resultArr[0])){
                log.info("result is : 03 ");
                System.out.println("result is : 03 ");
                return result;
            }else {
                log.info("result is : -1 ");
                System.out.println("result is : -1 ");
                return "-1";
            }
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
        LingXianHuLianSMSServiceImpl service = new LingXianHuLianSMSServiceImpl();
        service.setUsr("jinxinyuyin");
        service.setPasswd("jinxinyuyin");
        service.setUrl("http://101.200.29.88:8082/SendMT/SendMessage");
        service.sendSMSByTemplate("15201368252","81087",new String[]{"11111"});
    }
}
