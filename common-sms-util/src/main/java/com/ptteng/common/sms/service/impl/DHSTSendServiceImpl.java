package com.ptteng.common.sms.service.impl;

import java.beans.Encoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Map;

import com.dahantc.api.sms.json.JSONHttpClient;
import com.dahantc.api.sms.json.SmsData;
import com.ptteng.common.sms.service.SMSSendService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by asus on 2016/11/8.
 */
public class DHSTSendServiceImpl implements SMSSendService{

    protected Log log = LogFactory.getLog(this.getClass());

    private String account ;// 用户名（必填）
    private String password ;// 密码（必填）
    public String sign ; // 短信签名（必填）
    public String subcode = ""; // 子号码（选填）
    public String msgid ; // 短信id，查询短信状态报告时需要，（可选）
    public String sendtime = ""; // 定时发送时间（可选）

    public DHSTSendServiceImpl() {
    }

    @Override
    public String sendSMS(String mobile, String content) {
        return null;
    }

    @Override
    public String sendSMSByTemplate(String mobile, String template, String[] params) {
        String sendhRes = "";

        try {
            this.log.info(" params 0 = " + params[0]);
            String content = params[0];

            JSONHttpClient jsonHttpClient = new JSONHttpClient("http://www.dh3t.com");
            jsonHttpClient.setRetryCount(1);
            sendhRes = jsonHttpClient.sendSms(account, password, mobile, content, sign, subcode);
            log.info("提交单条普通短信响应：" + sendhRes);


            // List<SmsData> list = new ArrayList<SmsData>();
            //list.add(new SmsData("13912345678,13112345678",
            //content1, msgid, sign, subcode, sendtime));
            //list.add(new SmsData("18412345678", content2, msgid, sign,
            //subcode, sendtime));
            //String sendBatchRes = jsonHttpClient.sendBatchSms(account,
            //password, list);
            //LOG.info("提交批量短信响应：" + sendBatchRes);
            //
            // String reportRes = jsonHttpClient.getReport(account, password);
            // LOG.info("获取状态报告响应：" + reportRes);
            //
            // String smsRes = jsonHttpClient.getSms(account, password);
            // LOG.info("获取上行短信响应：" + smsRes);

        } catch (Exception e) {

            log.error("应用异常", e);
        }

        return sendhRes;
    }

    @Override
    public String sendSMSByTemplateByMore(String mobile, String template, Map<String, String> params) {
        return null;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }
}
