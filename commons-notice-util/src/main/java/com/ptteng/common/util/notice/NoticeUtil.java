package com.ptteng.common.util.notice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by liangxj on 2016/3/5.
 */
public interface NoticeUtil {
    /**
     *
     * @param channelId
     * @param message 推送的信息
     * @param type  安卓或者IOS  3 for android, 4 for ios
     */
    /**
     *
     * @param channelId  channelId
     * @param title  标题
     * @param message   具体信息
     * @param deviceType   //设置设备类型，deviceType => 1 for web, 2 for pc,
    //3 for android, 4 for ios, 5 for wp.
     * @param messageType //设置消息类型,0表示透传消息,1表示通知,默认为0.
     * @param msgExpires  //消息的有效时间   最大是7天
     */
    void pushMessae(String channelId,String title,String message,Integer deviceType,Integer messageType
    ,Integer msgExpires,String custom_content);

    /**
     * 发送群体消息
         * @param platfrom 设备  android ios
     * @param displayType 必填 消息类型  notification-通知，message-消息
     * @param type  // 必填 消息发送类型,其值可以为:
     *              unicast-单播
                     listcast-列播(要求不超过500个device_token)

     * @param deviceTokens  当type=unicast时,必填, 表示指定的单个设备
                            当type=listcast时,必填,要求不超过500个,
     * @param ticker // 必填 通知栏提示文字
     * @param title  // 必填 通知标题
     * @param text   // 必填 通知文字描述
     * @param afterOpen 必填 值可以为:  "go_app": 打开应用 "go_url": 跳转到URL "go_activity": 打开特定的activity
     * @param url  选 当"after_open"为"go_url"时，必填。通知栏点击后跳转的URL，要求以http或者https开头
     * @param activity 可选 当"after_open"为"go_activity"时，必填。通知栏点击后打开的Activity

     * @param custom
     * @param extra // 可选 用户自定义key-value。只对"通知" jsonObject  {
    "key1": "value1",
    "key2": "value2",
    ...
    }
     * @param start_time 定时发送时间，若不填写表示立即发送。
     * @param out_biz_no 开发者对消息的唯一标识，服务器会根据这个标识避免重复发送
     * @param production_mode "true/false" // 可选 正式/测试模式。测试模式下，只会将消息发给测试设备。
     * @param expire_time 可选 消息过期时间,
     * @param description   // 可选 发送消息描述，建议填写。
     *
     *
     *                      返回值格式：{"ret":"SUCCESS"}
     *                     或 {"ret":"FAIL","data":{"error_code":"111"}}
     */
    String pushMessaeForList(String platfrom,String displayType,String type,String deviceTokens,String ticker,
                           String title,String text,String afterOpen,String url,String activity,String custom,
                           String extra,Long start_time,String out_biz_no,String production_mode,Long expire_time,
                           String description) throws IOException;
}
