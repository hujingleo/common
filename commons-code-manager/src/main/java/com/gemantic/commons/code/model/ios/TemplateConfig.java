package com.gemantic.commons.code.model.ios;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TemplateConfig implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4416261477994732598L;

	private String targetPath;
	private String targetName;
	
	
	
	
	
	public TemplateConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TemplateConfig(String targetPath, String targetName) {
		this.targetName=targetName;
		this.targetPath=targetPath;
		;
	}

	public String getTargetPath() {
		return targetPath;
	}
	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
	
	
	
	
	
	

}
