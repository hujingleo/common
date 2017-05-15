package com.ptteng.common.sms.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.cloopen.rest.sdk.CCPRestSDK;
import com.ptteng.common.sms.service.SMSSendService;

public class SMSSendServiceRYImpl implements SMSSendService {
    private static final Log log = LogFactory.getLog(SMSSendServiceRYImpl.class);


    private String uri;
    private String port;
    private String account;//ACCOUNT SID
    private String pswd;//AUTH TOKEN
    private String product;//AppID

    //需要在容联创建自己的模板，创建好后，会有模块ID，写在smsServiceImpl的配置文件里，type_template这bean的参数

    @Override
    public String sendSMS(String mobile, String content) {

        try {
            HashMap<String, Object> result = null;
            CCPRestSDK restAPI = new CCPRestSDK();
            restAPI.init(this.uri, this.port);// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
            restAPI.setAccount(this.account, this.pswd);// 初始化主帐号名称和主帐号令牌
            restAPI.setAppId(this.product);// 初始化应用ID
            result = restAPI.sendTemplateSMS(mobile, "1", new String[]{"8888", "2"});

            log.info("SDKTestGetSubAccounts result=" + result);
            if ("000000".equals(result.get("statusCode"))) {
                //正常返回输出data包体信息（map）
                HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
                Set<String> keySet = data.keySet();
                for (String key : keySet) {
                    Object object = data.get(key);
                    log.info(key + " = " + object);
                }
            } else {
                //异常返回输出错误码和错误信息
                log.info("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.error(e.getMessage());
            log.error(mobile + " not send success " + content);
        }
        return "";


    }


    public String getUri() {
        return uri;
    }


    public void setUri(String uri) {
        this.uri = uri;
    }


    public String getAccount() {
        return account;
    }


    public void setAccount(String account) {
        this.account = account;
    }


    public String getPswd() {
        return pswd;
    }


    public void setPswd(String pswd) {
        this.pswd = pswd;
    }


    public String getProduct() {
        return product;
    }


    public void setProduct(String product) {
        this.product = product;
    }


    public String getPort() {
        return port;
    }


    public void setPort(String port) {
        this.port = port;
    }


    @Override
    public String sendSMSByTemplate(String mobile, String template, String[] params) {

        try {
            HashMap<String, Object> result = null;
            CCPRestSDK restAPI = new CCPRestSDK();
            restAPI.init(this.uri, this.port);// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
            restAPI.setAccount(this.account, this.pswd);// 初始化主帐号名称和主帐号令牌
            restAPI.setAppId(this.product);// 初始化应用ID
            result = restAPI.sendTemplateSMS(mobile, template, params);
            System.out.println("SDKTestGetSubAccounts result=" + result);
            log.info("SDKTestGetSubAccounts result=" + result);
            if ("000000".equals(result.get("statusCode"))) {
                //正常返回输出data包体信息（map）
                HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
                Set<String> keySet = data.keySet();
                for (String key : keySet) {
                    Object object = data.get(key);
                    System.out.println(key + " =  =" + object);

                    log.info(key + " = " + object);
                }
            } else {
                System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));

                //异常返回输出错误码和错误信息
                log.info("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error(mobile + " not send success of template " + template);
        }
        return "";


    }

    @Override
    public String sendSMSByTemplateByMore(String mobile, String template, Map params) {
        return null;
    }


    public static void main(String[] args){
        SMSSendServiceRYImpl service = new SMSSendServiceRYImpl();
        service.setUri("app.cloopen.com");
        service.setPort("8883");
        service.setAccount("8a216da85624dadc01562546c51f012f");
        service.setPswd("86486c3e1b7848f3b19803ac3ca63e2f");
        service.setProduct("8a216da85624dadc01562546c5780135");
        service.sendSMSByTemplate("15201368252","104834",new String[]{"22222","10"});
    }
}
