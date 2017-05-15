package com.ptteng.common.util.noticeImpl;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.ptteng.common.util.notice.NoticeUtil;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by liangxj on 2016/3/5.
 */
public class BaiduNoticeUtilImpl implements NoticeUtil {
    private static final Log log = LogFactory
            .getLog(BaiduNoticeUtilImpl.class);

    private String apiKey;
    private String secretKey;
    private PushKeyPair pushKeyPair;


    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void initClient(){
        pushKeyPair = new PushKeyPair(apiKey,secretKey);
    }

    @Override
    public void pushMessae(String channelId,String title, String message,Integer deviceType,
                                Integer messageType,Integer msgExpires,String custom_content) {

           /*1. 创建PushKeyPair
         *用于app的合法身份认证
         *apikey和secretKey可在应用详情中获取
         */
        String apiKey =this.apiKey;
        String secretKey = this.secretKey;
     //   PushKeyPair pair = new PushKeyPair(apiKey,secretKey);

        // 2. 创建BaiduPushClient，访问SDK接口
        BaiduPushClient pushClient = new BaiduPushClient(pushKeyPair,
                BaiduPushConstants.CHANNEL_REST_URL);

        // 3. 注册YunLogHandler，获取本次请求的交互信息
        pushClient.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent event) {
                System.out.println(event.getMessage());
            }
        });

        try {
            // 4. 设置请求参数，创建请求实例
            PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest().
                    addChannelId(channelId).
                    addMsgExpires(msgExpires).   //设置消息的有效时间,单位秒,默认3600*5.
                    addMessageType(messageType).           //设置消息类型,0表示透传消息,1表示通知,默认为0.
                    addMessage("{\"title\":"+"\""+title+"\",\"description\":"+"\""+message+"\""+",\"custom_content\":"+custom_content+"}").
                    addDeviceType(deviceType)
                    ;      //设置设备类型，deviceType => 1 for web, 2 for pc,

            //3 for android, 4 for ios, 5 for wp.
            // 5. 执行Http请求
            PushMsgToSingleDeviceResponse response = pushClient.
                    pushMsgToSingleDevice(request);
            // 6. Http请求返回值解析
            System.out.println("msgId: " + response.getMsgId()
                    + ",sendTime: " + response.getSendTime());
        } catch (PushClientException e) {
            //ERROROPTTYPE 用于设置异常的处理方式 -- 抛出异常和捕获异常,
            //'true' 表示抛出, 'false' 表示捕获。

            e.printStackTrace();

        } catch (PushServerException e) {

            System.out.println(String.format(
                    "requestId: %d, errorCode: %d, errorMsg: %s",
                    e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));

        }

    }

    @Override
    public String pushMessaeForList(String platfrom, String displayType, String type, String deviceTokens, String ticker, String title, String text, String afterOpen, String url, String activity, String custom, String extra, Long start_time, String out_biz_no, String production_mode, Long expire_time, String description) {

        return null;
    }

    public static void main(String[] args) {
        BaiduNoticeUtilImpl noticeUtil = new BaiduNoticeUtilImpl();
        noticeUtil.setApiKey("fv9UgNUIpIPPs5BjyoHA04w2");
        noticeUtil.setSecretKey("DI2hxKaFitjFZQ4WGQIF0ZibhebATWmi");
        noticeUtil.initClient();
        String ss = "{\"cid\":\"1\",\"pid\":\"2\"}";
        noticeUtil.pushMessae("3810377664273099356","BCC金融","你好3",3,1,86400 * 7,ss);
    }




}
