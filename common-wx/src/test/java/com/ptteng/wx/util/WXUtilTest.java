package com.ptteng.wx.util;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.qding.commnunity.common.weixin.service.impl.WeiXinServiceImpl;
import com.qding.common.util.FileUtil;
import com.qding.community.common.weixin.vo.JSAPI;


public class WXUtilTest {
	
    public static   String appid = "wx37f81bab6101e630";
    public static   String appsecret = "a19e97b91898ed7d98c79e9970699d57";
	private static final Log log = LogFactory.getLog(WXUtilTest.class);
	
	//@Test
	public void testGetJSAPI(){
		

	    
	    
		WeiXinServiceImpl ws=new WeiXinServiceImpl(appid, appsecret);
		JSAPI jsapi=ws.getJSAPI(appid, appsecret, "http://paper.ptteng.com");
		log.info(jsapi);
		
	}
	@Test
	public void testEmpty(){
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		String online_appid="wxfc7ed78d2bedf5ff";
		String online_secret="e04147f4ee80b2b707d8a591c9965e5d";
		boolean online =false;
		if(online){
			 WeiXinServiceImpl ws=new WeiXinServiceImpl(online_appid, online_secret);
				
				String test=ws.queryMenu(appid, appsecret);
				log.info(test);
			String menu=FileUtil.readFileAsString("d:/wx/menu/menu-online.txt");
				ws.publishMenu(appid, appsecret, menu);
				log.info("222222222");
		}else{
			 WeiXinServiceImpl ws=new WeiXinServiceImpl(appid, appsecret);
				
				String test=ws.queryMenu(appid, appsecret);
				log.info(test);
				String menu=FileUtil.readFileAsString("d:/wx/menu/menu.txt");
				ws.publishMenu(appid, appsecret, menu);
				log.info("222222222");
		}
         
	}
	
	
	
	

}
