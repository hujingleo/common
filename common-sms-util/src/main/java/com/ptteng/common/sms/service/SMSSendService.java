package com.ptteng.common.sms.service;

import java.util.List;
import java.util.Map;

public interface SMSSendService {
	/**
	 * 直接写好发送内容
	 * @param mobile
	 * @param content
	 * @return
	 */

	public String sendSMS(String mobile, String content);
	
	
	
	/**
	 * 通过模板发送短信
	 * @param mobile
	 * @return
	 */

	public String sendSMSByTemplate(String mobile, String template,String[] params);

	/**
	 * 通过模板发送多种参数的短信内容
	 * @param mobile
	 * @return
	 */

	public String sendSMSByTemplateByMore(String mobile, String template,Map<String,String> params);




}
