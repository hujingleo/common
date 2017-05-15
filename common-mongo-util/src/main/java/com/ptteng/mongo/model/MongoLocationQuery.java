package com.ptteng.mongo.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MongoLocationQuery implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9064545969835119906L;
	
	private MongoLocationQueryItem $near;
	
	
	
	
	
	
	public MongoLocationQueryItem get$near() {
		return $near;
	}






	public void set$near(MongoLocationQueryItem $near) {
		this.$near = $near;
	}






	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
