package com.ptteng.common.sms.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.dahantc.api.voice.json.HttpJSONClient;
import com.dahantc.api.voice.json.VoiceReqData;
import com.ptteng.common.sms.service.VoiceSendService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by asus on 2016/8/24.
 */
public class VoiceDHSTSendServiceImpl implements VoiceSendService {

    protected Log log = LogFactory.getLog(this.getClass());

    private String account ;
    private String password ;

    @Override
    public String sendVoice(String mobile, String code) {

        String submitResp = "";

        try {
            //初始化客户端
            HttpJSONClient client = new HttpJSONClient("http://voice.3tong.net");

            List<VoiceReqData> list = new ArrayList<VoiceReqData>();
            list.add(new VoiceReqData(mobile, code, "", "", 1, 0));//平台默认提示音 验证码短信
            //list.add(new VoiceReqData("13812345678", "211457", "dh9876tishiyin", "", 1, 0)); //自定义提示音 验证码短信
            submitResp = client.sendAuthCodeVoiceSms(account, password, list);
            log.info(submitResp);

            String reportResp = client.getVoiceReport(account, password);
            log.info(reportResp);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return submitResp;
    }


//    public static void main(String[] args) {
//        try {
//            //初始化客户端
//            HttpJSONClient client = new HttpJSONClient("http://voice.3tong.net");
//
//            List<VoiceReqData> list = new ArrayList<VoiceReqData>();
//            list.add(new VoiceReqData("18817008901", "211456", "", "", 1, 0));//平台默认提示音 验证码短信
//            //list.add(new VoiceReqData("13812345678", "211457", "dh9876tishiyin", "", 1, 0)); //自定义提示音 验证码短信
//            String submitResp = client.sendAuthCodeVoiceSms(account, password, list);
//            System.out.println(submitResp);
//
//            String reportResp = client.getVoiceReport(account, password);
//
//            System.out.println(reportResp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }


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
