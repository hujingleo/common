package com.gemantic.commons.code.model.ios;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IOSController implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8388742994526977190L;
	private String name;

	private List<IOSField> fields;
    private TemplateConfig mTemplateConfig;
    private TemplateConfig hTemplateConfig;

	
	
	
	
	
	
	
	
	







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
	
	
	







	public TemplateConfig getMTemplateConfig() {
		return mTemplateConfig;
	}







	public void setMTemplateConfig(TemplateConfig mTemplateConfig) {
		this.mTemplateConfig = mTemplateConfig;
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







	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
	

}
