package com.gemantic.commons.code.model.ios;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IOSField implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8393295007715655176L;
	
	
	private Set<String> baseTypes=new HashSet<String>(Arrays.asList("NSString"));;
	
	
	private String ctype;
	private String cname;
	private String color;
	private String comment;
	private boolean baseType;	
	private boolean publicField;
	
	private IOSPosition position;
	
	private String fieldTemplatePath="velocity/ios/field/field.vm";
	
	
	
	
	
	public IOSField() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IOSField(String type, String name) {
		this.ctype=type;
		this.cname=name;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
		if(baseTypes.contains(ctype)){
			baseType=true;
		}else{
			baseType=false;
		}
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	

	public Set<String> getBaseTypes() {
		return baseTypes;
	}
	public void setBaseTypes(Set<String> baseTypes) {
		this.baseTypes = baseTypes;
	}
	public boolean isBaseType() {
		return baseType;
	}
	public void setBaseType(boolean baseType) {
		this.baseType = baseType;
	}
	public boolean isPublicField() {
		return publicField;
	}
	public void setPublicField(boolean publicField) {
		this.publicField = publicField;
	}
	public IOSPosition getPosition() {
		return position;
	}
	public void setPosition(IOSPosition position) {
		this.position = position;
	}
	
	
	
	
	
	public String getFieldTemplatePath() {
		return fieldTemplatePath;
	}
	public void setFieldTemplatePath(String fieldTemplatePath) {
		this.fieldTemplatePath = fieldTemplatePath;
	}
	
	
	
	public String capitalize(String key){
		   return 	StringUtils.capitalize(key);
		}
		
		public String uncapitalize(String key){
			return StringUtils.uncapitalize(key);
		}
		
		
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
	
	
	
	
	
	
	
	
	
	

}
