package com.gemantic.commons.code.model.ios;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IOSService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1251265982519848901L;
	
	private String name;
	private List<IOSInterface> interfaces;
	
	private TemplateConfig mTemplateConfig;
    private TemplateConfig hTemplateConfig;
    
    
    
	
	

	public TemplateConfig getmTemplateConfig() {
		return mTemplateConfig;
	}

	public void setmTemplateConfig(TemplateConfig mTemplateConfig) {
		this.mTemplateConfig = mTemplateConfig;
	}

	public TemplateConfig gethTemplateConfig() {
		return hTemplateConfig;
	}

	public void sethTemplateConfig(TemplateConfig hTemplateConfig) {
		this.hTemplateConfig = hTemplateConfig;
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
