package com.gemantic.commons.code.model.android;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gemantic.commons.code.model.ios.IOSInterface;
import com.gemantic.commons.code.model.ios.TemplateConfig;

public class AndroidService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1251265982519848901L;
	
	private String name;
	private List<IOSInterface> interfaces;
	
	private TemplateConfig templateConfig;
	
	
	
   
    
    
    
	
	public TemplateConfig getTemplateConfig() {
		return templateConfig;
	}

	public void setTemplateConfig(TemplateConfig templateConfig) {
		this.templateConfig = templateConfig;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	



	public List<IOSInterface> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<IOSInterface> interfaces) {
		this.interfaces = interfaces;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
	

}
