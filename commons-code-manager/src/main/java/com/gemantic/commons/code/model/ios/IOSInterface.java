package com.gemantic.commons.code.model.ios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.tuple.Pair;

public class IOSInterface implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8029884712169513516L;



	public static final String Http_Method_Post = "post";
	public static final String Http_Method_Get = "get";
	public static final String Http_Method_Put = "put";
	public static final String Http_Method_Delete = "delete";
	
	
	
	
	private String name;
	private String url;
	private String serviceMethod;
	private String httpMethod;
	private String comment;
	
	private List<IOSField> params=new ArrayList();
	
	private String modelName;
	
	private String modelType;

    private TemplateConfig configTemplateConfig;
   
 
	
	
	private boolean array;
	
	
	
	
	
	
	
	
	public String getUrl() {
		return url;
	}









	public void setUrl(String url) {
		this.url = url;
	}









	









	public List<IOSField> getParams() {
		return params;
	}









	public void setParams(List<IOSField> params) {
		this.params = params;
	}









	public String getModelName() {
		return modelName;
	}









	public void setModelName(String modelName) {
		this.modelName = modelName;
	}









	public String getModelType() {
		return modelType;
	}









	public void setModelType(String modelType) {
		this.modelType = modelType;
	}









	public String getServiceMethod() {
		return serviceMethod;
	}









	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}








	
	
	









	public boolean isArray() {
		return array;
	}









	public void setArray(boolean array) {
		this.array = array;
	}
	
	
	
	














	public TemplateConfig getConfigTemplateConfig() {
		return configTemplateConfig;
	}









	public void setConfigTemplateConfig(TemplateConfig configTemplateConfig) {
		this.configTemplateConfig = configTemplateConfig;
	}
	
	









	public String getName() {
		return name;
	}









	public void setName(String name) {
		this.name = name;
	}
	
	
	









	public String getHttpMethod() {
		return httpMethod;
	}









	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}









	public String getComment() {
		return comment;
	}









	public void setComment(String comment) {
		this.comment = comment;
	}











	
	public String convert2IOSHttpKeyParameter(){
		StringBuffer sb=new StringBuffer();
		List<IOSField> keys= this.params;
		for (int i = 0; i < keys.size(); i++) {
			IOSField field=keys.get(i);
			sb=sb.append(field.getCname());
			sb=sb.append("=%@");
		    if(i<keys.size()-1){
		    	sb=sb.append("&");
		    }
			
		}
		
		return sb.toString();
		
		
		
	}
	
	public String convert2IOSHttpValueParameter(){
		StringBuffer sb=new StringBuffer();
		List<IOSField> keys= this.params;
	
		for (int i = 0; i < keys.size(); i++) {
			IOSField field=keys.get(i);
			sb=sb.append(field.getCname());			
		    if(i<this.params.size()-1){
		    	sb=sb.append(",");
		    }
			
		}
		
		return sb.toString();
		
		
		
	}
	
	
	








	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
	
	

}
