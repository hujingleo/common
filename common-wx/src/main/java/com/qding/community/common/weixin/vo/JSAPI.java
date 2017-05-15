package com.qding.community.common.weixin.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JSAPI implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5830426031032768129L;
	
	
	private String appId;
	private String timestamp;
	private String nonceStr;
	private String signature;
	
	
	
	
	
	public JSAPI(String appId, String timestamp, String nonceStr,
			String signature) {
		super();
		this.appId = appId;
		this.timestamp = timestamp;
		this.nonceStr = nonceStr;
		this.signature = signature;
	}





	public JSAPI() {
		super();
		// TODO Auto-generated constructor stub
	}





	public String getAppId() {
		return appId;
	}





	public void setAppId(String appId) {
		this.appId = appId;
	}





	public String getTimestamp() {
		return timestamp;
	}





	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}





	public String getNonceStr() {
		return nonceStr;
	}





	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}





	public String getSignature() {
		return signature;
	}





	public void setSignature(String signature) {
		this.signature = signature;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
