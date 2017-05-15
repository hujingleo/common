package com.ptteng.common.util;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qding.common.util.PinyinUtil;

public class PinYinUtil {
	
	private static final Log log = LogFactory.getLog(PinYinUtil.class);
	
	
	public static void main(String[] args) {
		
				
	/*		String dx=	PinyinUtil.getAcronymFromPinyin("中华人民共和国");
			log.info(dx);*/
			
		String[] pinyin=	PinyinUtil.getPinyin("中华人民共和国");
		
		String[] content=PinyinUtil.getPinyinAcronym("中华人民共和国");
		
		log.info(Arrays.asList(content));
			
		
	}

}
