package com.ptteng.common.storage.util;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

public class ImgStorageUtilTest {
	
	private static final Log log = LogFactory.getLog(ImgStorageUtilTest.class);

	private ImgStorageUtil imgStrorageUtil;

	@Before
	public void init() {
		// imgStrorageUtil=new ImgStrorageUtilYPImpl();
		imgStrorageUtil = new ImgStorageUtilJSImpl("v0pvlzNN9AAhb+aSgpGt","JgxhB2gAcitx5MHQArOLwt0h0gTsWVmoFl4R");
	}

	//@Test
	public void testJS() {

		String dir = "testcrop";
		String file = "D:\\pic\\qc.png";
		try {
			String url = imgStrorageUtil.imgStorage("wangjia-advertise-dev", "xd/"+String.valueOf(System.currentTimeMillis()), file);
			
			// String url2=imgStrorageUtil.ImgCrop(dir, file,
			// "100,100,100,100");
			

			log.info(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void testNull(){
		
	}

	public static void main(String[] args) {

		ImgStorageUtil imgStrorageUtil = new ImgStorageUtilYPImpl();

		String dir = "online-nurse";
		String file = "/Users/arthur/Downloads/pic1.jpg";
		try {
			String url = imgStrorageUtil.imgStorage(dir, null, file);
			// String url2=imgStrorageUtil.ImgCrop(dir, file,
			// "100,100,100,100");

			System.out.print(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImgStorageUtil imgStrorageUtil2 = new ImgStorageUtilFastDFSImpl();

		

	}

}
