package com.ptteng.common.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.qding.common.util.PinyinUtil;


public class PinYinCompare  implements Comparator<String> {
	private static final Log log = LogFactory.getLog(PinYinCompare.class);
	

	
	public int compare(String o1, String o2) {
		
			for (int i = 0; i < o1.length() && i < o2.length(); i++) {
				char c1 = o1.charAt(i);
		        char c2 = o2.charAt(i);
		        
		        String pinyin1 = pinyin(c1);
		        String pinyin2 = pinyin(c2);

		        if (pinyin1 != null && pinyin2 != null) {

		            if (!pinyin1.equals(pinyin2)) {
		                return pinyin1.compareTo(pinyin2);
		            }
		        }else{
		        	if(o1.length()==o2.length()){
			           if (c1 != c2) {
			           return c1 - c2;
			           }
		        	}
		        }
			}
			if(o1.length()>o2.length()){
				return 1 ;
			}
			if(o1.length()<o2.length()){
				return -1;
			}else{
				return 0;
			}
		}

	private static String pinyin(char c) {		
		String[] values = PinyinUtil.getPinyin(String.valueOf(c));
		if (values != null && values.length > 0)
			return values[0];
		
		return null;
	}

	
	public static void main(String[] args) {
		
		PinYinCompare comparator=new PinYinCompare();
		  List<String> userlist=new ArrayList();
		  userlist.add("冯");
		  userlist.add("冯培宇");
		  userlist.add("冯培");
		  userlist.add("任海丽");
		  userlist.add("任大丽");
		  userlist.add("阿晨飞");
		  userlist.add("bad");
		  userlist.add("菜鸟");
		  userlist.add("大力");
		
		  
		  
		  
		Collections.sort(userlist, comparator);
		
		log.info(userlist);
		
	}
}
