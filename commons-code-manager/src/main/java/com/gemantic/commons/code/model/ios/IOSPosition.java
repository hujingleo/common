package com.gemantic.commons.code.model.ios;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IOSPosition implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8167172673419120485L;
	
	
	private String x;
	private String y;
	private String width;
	private String height;
	
	
	
	

	public IOSPosition(String x, String y, String width,
			String height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	
	





	public IOSPosition() {
		super();
		// TODO Auto-generated constructor stub
	}








	public String getX() {
		return x;
	}





	public void setX(String x) {
		this.x = x;
	}





	public String getY() {
		return y;
	}





	public void setY(String y) {
		this.y = y;
	}





	public String getWidth() {
		return width;
	}





	public void setWidth(String width) {
		this.width = width;
	}





	public String getHeight() {
		return height;
	}





	public void setHeight(String height) {
		height = height;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
		
	}
}
