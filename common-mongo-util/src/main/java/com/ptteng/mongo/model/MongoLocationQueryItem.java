package com.ptteng.mongo.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MongoLocationQueryItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8306560878852306719L;
	private MongoLocation $geometry;
	private Double $maxDistance;
	public MongoLocation get$geometry() {
		return $geometry;
	}
	public void set$geometry(MongoLocation $geometry) {
		this.$geometry = $geometry;
	}
	public Double get$maxDistance() {
		return $maxDistance;
	}
	public void set$maxDistance(Double $maxDistance) {
		this.$maxDistance = $maxDistance;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	

}
