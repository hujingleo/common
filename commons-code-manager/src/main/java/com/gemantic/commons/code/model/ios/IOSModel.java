package com.gemantic.commons.code.model.ios;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IOSModel implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5353304614874091862L;
	
	
	private String name;
	private String type;
	
	private List<IOSField> fields;
    private TemplateConfig mTemplateConfig;
    private TemplateConfig hTemplateConfig;
    private String convertJson;
    
    
    
    
    
    
    
    
    
	

	public String getConvertJson() {
		return convertJson;
	}

	public void setConvertJson(String convertJson) {
		this.convertJson = convertJson;
	}

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
	
	
	


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
}
