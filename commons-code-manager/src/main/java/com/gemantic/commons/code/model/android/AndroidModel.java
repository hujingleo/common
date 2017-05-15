package com.gemantic.commons.code.model.android;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.gemantic.commons.code.model.ios.IOSField;
import com.gemantic.commons.code.model.ios.TemplateConfig;

public class AndroidModel implements Serializable{
	
	
	






	/**
	 * 
	 */
	private static final long serialVersionUID = 8388742994526977190L;
	private String name;

	private List<IOSField> fields;
    private TemplateConfig templateConfig;
 

	
	
	
	
	
	
	

	







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
	
	
	
	
	
	













	


	public TemplateConfig getTemplateConfig() {
		return templateConfig;
	}







	public void setTemplateConfig(TemplateConfig templateConfig) {
		this.templateConfig = templateConfig;
	}







	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
	

}
