package com.ptteng.common.sms.service.impl;

import com.cloopen.rest.sdk.CCPRestSDK;
import com.ptteng.common.sms.service.VoiceSendService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;

/**
 * Created by Xu on 16/4/17.
 */
public class RongLianServiceImpl implements VoiceSendService {

    protected Log log = LogFactory.getLog(this.getClass());

    private String url;
    private String serverPort;
    private String accountSid;
    private String accountToken;
    private String appId;
    private String displayNum;
    private String playTimes;
    private String respUrl;

    @Override
    public String sendVoice(String mobile, String code) {
        HashMap result = null;
        CCPRestSDK restAPI = new CCPRestSDK();

        // 初始化服务器地址和端口，沙盒环境配置成sandboxapp.cloopen.com，生产环境配置成app.cloopen.com，端口都是8883.
        restAPI.init(url, serverPort);

        // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在"控制台-应用"中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
        restAPI.setAccount(accountSid, accountToken);

        // 初始化应用ID，如果是在沙盒环境开发，请配置"控制台-应用-测试DEMO"中的APPID。如切换到生产环境，请使用自己创建应用的APPID
        restAPI.setAppId(appId);

        result = restAPI.voiceVerify(code, mobile, displayNum, playTimes, respUrl);

        // log.info("SDKTestVoiceVerify result=" + result);

        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            return "Success: SDKTestVoiceVerify result=" + result;
        } else {
            //异常返回输出错误码和错误信息
            return "Error: SDKTestVoiceVerify result=" + result;
        }
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAccountToken() {
        return accountToken;
    }

    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDisplayNum() {
        return displayNum;
    }

    public void setDisplayNum(String displayNum) {
        this.displayNum = displayNum;
    }

    public String getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(String playTimes) {
        this.playTimes = playTimes;
    }

    public String getRespUrl() {
        return respUrl;
    }

    public void setRespUrl(String respUrl) {
        this.respUrl = respUrl;
    }
}
