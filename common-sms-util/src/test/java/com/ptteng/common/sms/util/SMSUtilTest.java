package com.ptteng.common.sms.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.ptteng.common.sms.service.VideoSendService;
import com.ptteng.common.sms.service.impl.SMSSendServiceRYImpl;
import com.ptteng.common.sms.service.impl.VideSendServiceJSImpl;

public class SMSUtilTest {
	
	private static final Log log = LogFactory.getLog(SMSUtilTest.class);
	
	//@Test
	public void testSMS(){
		
		
		SMSSendServiceRYImpl smsUtil=new SMSSendServiceRYImpl();	
	
		
		smsUtil.setAccount("8a48b5514e3e5862014e3e9fa7e500b0");
		smsUtil.setPort("8883");
		smsUtil.setProduct("8a48b5514e3e5862014e4323b8fc03f7");
		smsUtil.setPswd("c9cdbbbf0e6d41238b5331df9a4b67ea");
		smsUtil.setUri("sandboxapp.cloopen.com");
		
		
		smsUtil.sendSMSByTemplate("13466789042", "1",new String[]{"2222","2"});
	}
	
	@Test
	public void testNull(){
		
	}
	
	//@Test
	public void testVideo(){
		
		VideoSendService  videoSendService=new VideSendServiceJSImpl();
		String code=videoSendService.sendVideo("13466789042","http://www.ptteng.com/video/32");
		
		
	}

}
