package com.ptteng.mongo.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MongoLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7350483506345999191L;
	public static final String Type_Point = "Point";
	private String type;
	private Double[] coordinates;

	public MongoLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MongoLocation(String type, Double[] coordinates) {
		this.type = type;
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	

	public Double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Double[] coordinates) {
		this.coordinates = coordinates;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
