package com.gemantic.commons.code.model.ios;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IOSView implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7571372498623487236L;
	
	private String name;

	private List<IOSField> fields;
    private TemplateConfig mTemplateConfig;
    private TemplateConfig hTemplateConfig;
    private String viewType;
    
    
    
    
    
	
	

	public String getName() {
		return name;
	}








	public void setName(String name) {
		this.name = name;
	}








	public List<IOSField> getFields() {
		return fields;
	}








	public void setFields(List<IOSField> fields) {
		this.fields = fields;
	}








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
	
	
	








	public String getViewType() {
		return viewType;
	}








	public void setViewType(String viewType) {
		this.viewType = viewType;
	}








	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}

}
