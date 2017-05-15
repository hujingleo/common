package com.ptteng.common.storage.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.ksyun.ks3.http.HttpClientConfig;
import com.ksyun.ks3.service.Ks3ClientConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ksyun.ks3.dto.CannedAccessControlList;
import com.ksyun.ks3.service.Ks3;
import com.ksyun.ks3.service.Ks3Client;
import com.ksyun.ks3.service.request.PutObjectRequest;
import com.ksyun.ks3.utils.StringUtils;
import org.joda.time.format.DateTimeFormat;

/**
 *  2016-11-4日修改：之前我们竟然一直使用的是杭州域名，现在做更改，用回北京域名
 * @author liangxiaojin
 */
public class ImgStorageUtilJSImpl implements ImgStorageUtil {
	private static final Log log = LogFactory
			.getLog(ImgStorageUtilJSImpl.class);

	private String akey;
	private String skey;

	private String bucketName;

	private Ks3 client;

	private String domain ;

	public ImgStorageUtilJSImpl(String akey, String skey) {
		super();
		this.akey = akey;
		this.skey = skey;
		client = new Ks3Client(akey, skey);
		log.info(" init client success ");
	}
	
	

	public ImgStorageUtilJSImpl() {
		super();
		client = new Ks3Client(akey, skey);
		log.info(" init client success ");
	}
	
	public void initClient(){
		client = new Ks3Client(akey, skey);
		log.info(" init client success ");
	}
	public void initClientConfig(){
		Ks3ClientConfig config = new Ks3ClientConfig();

		config.setEndpoint("ks3-cn-beijing.ksyun.com");   //域名使用传入的参数
		config.setProtocol(Ks3ClientConfig.PROTOCOL.http);
		config.setPathStyleAccess(false);
		config.setDomainMode(false);
		HttpClientConfig hconfig = new HttpClientConfig();
		config.setHttpClientConfig(hconfig);

		client = new Ks3Client(akey, skey,config);
		log.info(" init client success ");
	}
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

	public Ks3 getClient() {
		return client;
	}

	public void setClient(Ks3 client) {
		this.client = client;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 *
	 * @param dir
	 * @param yunFileName
	 * @param picFile
	 * @return
	 * @throws IOException
	 *
	 */
	@Override
	public String imgStorage(String dir, String yunFileName, String picFile)
			throws IOException {
		System.out.println(" bucketName = "+bucketName+" akey = "+akey +" skey = "+skey+"yunFileName= "+yunFileName
				+" picFile = "+picFile);
		log.info(" bucketName = " + bucketName + " akey = " + akey + " skey = " + skey + "yunFileName= " + yunFileName
				+ " picFile = " + picFile);
		String bucket=this.bucketName;
		if(StringUtils.isBlank(dir)){

			log.info("dir is empty,use default bucket ");
		}else{
			 bucket=dir;
		}




		PutObjectRequest request = new PutObjectRequest(bucket, yunFileName,
				new File(picFile));
		request.setCannedAcl(CannedAccessControlList.PublicRead);
		client.putObject(request);

		String url2 = this.generateUrl(bucket, yunFileName);
		log.info(bucket + " and key " + yunFileName + " get url2 is " + url2);

		/*String url = client.generatePresignedUrl(dir, yunFileName, 1000);
		log.info(dir + " dir  " + yunFileName + " yunFileName url is " + url);*/
		return url2;
	}

	@Override
	public String imgStorage(String url, int timeOneHour) throws IOException {
		System.out.println(" url = "+url+" timeOneHour = "+timeOneHour);
		String[] url1 =  url.split("\\/");
		String realKey = "";
		for(int i=3;i<url1.length;i++){
			if(i==url1.length-1){
				realKey = url1[i];
			}else {
				realKey = url1[i]+"/";
			}

		}
		realKey = java.net.URLDecoder.decode(realKey,"utf-8");
		//log.info(" realKey = "+realKey);
		log.info(" realKey = "+realKey+" buketName = "+bucketName);

		String link = client.generatePresignedUrl(bucketName, realKey, timeOneHour);
//		String[] link1 =  link.split("\\/");
//		StringBuilder ll = new StringBuilder("http://");
//		for(int i=0;i<link1.length;i++){
//			System.out.println(" i = "+i+" url = "+link1[i]);
//			if(i==2){
//				ll.append(link1[i]);
//			}
//			if(i==3){
//				ll.append("/"+realKey);
//			}
//			System.out.println(" ll = "+ll.toString());
//		}
//		String[] lll = link.split("\\?");
//		ll.append("\\?"+lll[1]);
//
//		//log.info(" link = "+link);
//		System.out.println(" link = " + ll.toString());
//
//		return ll.toString();
		log.info(" link = " + link);
		return link;
	}

	public static void main(String[] args){
//		ImgStorageUtilJSImpl imgStorageUtil = new ImgStorageUtilJSImpl();
//		imgStorageUtil.setBucketName("learn");
//		imgStorageUtil.setAkey("+vB0RuO22DeeanAAb0ig");
//		imgStorageUtil.setSkey("3kbTp8pg+LymO84/ZyxG/od/3FeVDjWt+8/m5iBc");
//		imgStorageUtil.initClientConfig();
//		try {
//
//			String url = imgStorageUtil.imgStorage("http://learn.ks3-cn-beijing.ksyun.com/%E5%90%8D%E4%BE%A6%E6%8E%A2%E7%A6%8F%E5%B0%94%E6%91%A9%E6%96%AF-%E7%AC%AC1%E9%9B%86.mp4"
//					,200);
//
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		ImgStorageUtilJSImpl imgStorageUtil = new ImgStorageUtilJSImpl();
		imgStorageUtil.setBucketName("jns.img.bucket");
		imgStorageUtil.setAkey("7f1+ognHaShOCgVMkXnV");
		imgStorageUtil.setSkey("w1fyop45mnIwlJj0g2l4UBrjuZeIlZMbgS4nicL2");
		imgStorageUtil.setDomain(".ks3-cn-beijing.ksyun.com");
		imgStorageUtil.initClientConfig();
		try {
			String url = imgStorageUtil.imgStorage(null, "im/c486fe54-599f-4024-82dd-b8e048ddd120.jpg", "/data/temp/2.jpg");
			System.out.print(url);

		} catch (IOException e) {
			e.printStackTrace();
		}


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
