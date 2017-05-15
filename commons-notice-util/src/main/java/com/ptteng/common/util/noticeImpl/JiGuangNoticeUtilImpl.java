package com.ptteng.common.util.noticeImpl;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

import com.ptteng.common.util.notice.NoticeUtil;

import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * Created by shangff on 2016/8/13.
 */
public class JiGuangNoticeUtilImpl implements NoticeUtil {

    private static final Log LOG = LogFactory.getLog(JiGuangNoticeUtilImpl.class);

    private String appKey;
    private String masterSecret;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getMasterSecret() {
        return masterSecret;
    }

    public void setMasterSecret(String masterSecret) {
        this.masterSecret = masterSecret;
    }

    @Override
    public void pushMessae(String channelId, String title, String message, Integer deviceType, Integer messageType, Integer msgExpires, String custom_content) {

    }

    /**
     * 发送群体消息
     *
     * @param platform        !必填 设备  android ios
     * @param displayType     !必填 消息类型  notification-通知，message-消息
     * @param type            !必填 消息发送类型,其值可以为: "unicast" (单播), "listcast" (列播)
     * @param deviceTokens    !必填 设备绑定的别名 当 type=unicast 时, 一个值; 当 type=listcast 时, 多个之间逗号隔开, 要求不超过 1000 个
     * @param ticker          // 没有用到 通知栏提示文字
     * @param title           ?可选 通知标题
     * @param text            !必填 通知内容
     * @param afterOpen       // 没有用到 值可以为:  "go_app": 打开应用 "go_url": 跳转到URL "go_activity": 打开特定的activity
     * @param url             // 没有用到 当"after_open"为"go_url"时，必填。通知栏点击后跳转的URL，要求以http或者https开头
     * @param activity        // 没有用到 当"after_open"为"go_activity"时，必填。通知栏点击后打开的Activity
     * @param custom          // 没有用到
     * @param extra           ?可选 用户自定义 key-value json 格式 对 message-消息 也有效果
     * @param start_time      // 定时发送时间，若不填写表示立即发送。
     * @param out_biz_no      // 开发者对消息的唯一标识，服务器会根据这个标识避免重复发送
     * @param production_mode ?可选 "true"/"false" (生产环境 / 开发环境) 不指定则为 生产环境
     * @param expire_time     ?可选 消息过期时间 这里是具体时间的毫秒值
     * @param description     // 没有用到 发送消息描述
     */
    @Override
    public String pushMessaeForList(String platform, String displayType, String type, String deviceTokens, //
                                    String ticker, String title, String text, String afterOpen, String url, //
                                    String activity, String custom, String extra, Long start_time, String out_biz_no, //
                                    String production_mode, Long expire_time, String description) throws IOException {


        JPushClient jpushClient = new JPushClient(masterSecret, appKey);

        PushPayload.Builder PayloadBuilder = PushPayload.newBuilder();

        PayloadBuilder.setPlatform(convertPlatform(platform));

        PayloadBuilder.setAudience(convertAudience(type, deviceTokens.split(",\\s*")));

        // 将 json 格式解析为 Map
        Map<String, String> extras;
        try {
            extras = JSONObject.fromObject(extra);
        } catch (Exception e) {
            extras = Collections.emptyMap();
        }

        if ("notification".equals(displayType)) {
            PayloadBuilder.setNotification(convertNotification(platform, title, text, extras));
        } else if ("message".equals(displayType)) {
            PayloadBuilder.setMessage(convertMessage(text, extras));
        }

        PayloadBuilder.setOptions(getOptions(production_mode, expire_time));

        try {
            PushResult result = jpushClient.sendPush(PayloadBuilder.build());
            LOG.info("Got result - " + result);
            return "{\"ret\":\"SUCCESS\"}";

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);
            return "{\"ret\":\"FAIL\",\"data\":{\"error_code\":\"FAIL\"}}";

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            return "{\"ret\":\"FAIL\",\"data\":{\"error_code\":"+ e.getErrorCode() + "}}";
        }

    }

    /**
     * @param production_mode  "true"/"false" (生产环境 / 开发环境) 不指定则为 生产环境
     * @param expire_time      消息过期时间 这里是具体时间的毫秒值
     * @return Options对象
     */
    private Options getOptions(String production_mode, Long expire_time) {
        Options.Builder builder = Options.newBuilder();
        builder.setApnsProduction(!"false".equals(production_mode));
        if(null != expire_time){
            long current = System.currentTimeMillis();
            long expire = (expire_time - current) / 1000;
            // 消息过期时间 单位:秒 默认 86400 (1天)
            builder.setTimeToLive(expire);
        }
        return builder.build();
    }

    /**
     * @param text   消息内容
     * @param extras 扩展字段
     * @return 消息对象 (Message)
     */
    private Message convertMessage(String text, Map<String, String> extras) {
        return Message.newBuilder().setMsgContent(text).addExtras(extras).build();
    }

    /**
     * @param type         消息发送类型,其值可以为: "unicast" (单播), "listcast" (列播)
     * @param deviceTokens 这里是每个设备的唯一别名 (alias), 当 type=listcast 时最多支持 1000 个
     * @return 推送设备对象 (Audience)
     */
    private Audience convertAudience(String type, String... deviceTokens) {
        if ("unicast".equals(type)) {
            if (deviceTokens.length == 1) {
                return Audience.alias(deviceTokens);
            }
        } else if ("listcast".equals(type)) {
            return Audience.alias(deviceTokens);
        }
        throw new IllegalArgumentException();
    }

    /**
     * @param platform 必填 代表平台的字符串 "ios" or "android"
     * @param title    可选	通知标题
     * @param text     必填 通知内容
     * @param extra    可选	扩展字段
     * @return 通知对象 (Notification)
     */
    private Notification convertNotification(String platform, String title, String text, Map<String, String> extra) {
        if ("ios".equals(platform)) {
            return Notification.ios(text, extra);
        } else if ("android".equals(platform)) {
            return Notification.android(text, title, extra);
        }
        return Notification.alert(text);
    }

    /**
     * @param platform 代表平台的字符串 "ios" or "android"
     * @return 平台对象 (Platform)
     */
    private Platform convertPlatform(String platform) {
        if ("ios".equals(platform)) {
            return Platform.ios();
        } else if ("android".equals(platform)) {
            return Platform.android();
        }
        return null;
    }

    public static void main(String[] args) {
        JiGuangNoticeUtilImpl utilTest = new JiGuangNoticeUtilImpl();

        utilTest.setAppKey("e5678f0eb18d058b6ba062ae");
        utilTest.setMasterSecret("26fdcf155c2a9dfce885ad60");

        try {
            String result = utilTest.pushMessaeForList(
                    "ios", "notification", "listcast", "13012345678", "",
                    "推送测试-01-title", "推送测试-01", "", "", "", "", "",
                    0L, "", "true", System.currentTimeMillis() + 7*24*60*60*1000, "");

            System.out.println("result = " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
