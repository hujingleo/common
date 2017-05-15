package com.ptteng.common.storage.util;

import com.ksyun.ks3.dto.CannedAccessControlList;
import com.ksyun.ks3.service.Ks3;
import com.ksyun.ks3.service.Ks3Client;
import com.ksyun.ks3.service.request.PutObjectRequest;
import com.ksyun.ks3.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ImgStorageUtilServerImpl implements ImgStorageUtil {
	private static final Log log = LogFactory
			.getLog(ImgStorageUtilServerImpl.class);

	private String akey;
	private String skey;

	private String bucketName;

	private String domain = ".ptteng.com";


	public String getAkey() {
		return akey;
	}

	public void setAkey(String akey) {
		this.akey = akey;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}


	@Override
	public String imgStorage(String dir, String yunFileName, String picFile)
			throws IOException {
		
		String bucket=this.bucketName;
		if(StringUtils.isBlank(dir)){
			
			log.info("dir is empty,use default bucket ");
		}else{
			 bucket=dir;
		}

		String url2 = this.generateUrl(bucket, yunFileName);
		log.info(bucket + " and key " + yunFileName + " get url2 is " + url2);

		/*String url = client.generatePresignedUrl(dir, yunFileName, 1000);
		log.info(dir + " dir  " + yunFileName + " yunFileName url is " + url);*/
		return url2;
	}

	@Override
	public String imgStorage(String url, int timeOneHour) throws IOException {
		return null;
	}

	private String generateUrl(String dir, String yunFileName) {
		StringBuffer sb = new StringBuffer();
		sb = sb.append("http://");
		sb = sb.append(dir);
		sb = sb.append(this.domain);
		sb = sb.append("/");
		sb = sb.append(yunFileName);
		return sb.toString();

	}

	@Override
	public String imgGmkerl(String dir, String yunFileName, String picFile,
			Map<String, String> params) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String imgRotate(String dir, String yunFileName, String picFile,
			String params) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String imgCrop(String dir, String yunFileName, String picFile,
			String params) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
