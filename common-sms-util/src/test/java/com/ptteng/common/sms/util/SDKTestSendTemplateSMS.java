package com.ptteng.common.sms.util;

import java.util.HashMap;
import java.util.Set;

import com.cloopen.rest.sdk.CCPRestSDK;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SDKTestSendTemplateSMS {

	protected Log log = LogFactory.getLog(this.getClass());
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Log log = LogFactory.getLog("test");

		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init("sandboxapp.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount("8a48b5514e3e5862014e3e9fa7e500b0", "c9cdbbbf0e6d41238b5331df9a4b67ea");// 初始化主帐号名称和主帐号令牌
		restAPI.setAppId("8a48b5514e3e5862014e4323b8fc03f7");// 初始化应用ID
		result = restAPI.sendTemplateSMS("18611867395","1" ,new String[]{"8888","2"});

		log.info("SDKTestGetSubAccounts result=" + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				log.info(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			log.info("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
	}

}
