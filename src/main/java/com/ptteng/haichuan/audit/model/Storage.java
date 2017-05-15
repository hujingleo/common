package com.ptteng.haichuan.audit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Entity
@Table(name = "storage")
public class Storage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5052620894030736384L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String name;
	
  	 
    private  String attribute;
	
  	 
    private  String latitude;
	
  	 
    private  String longitude;
	
  	 
    private  String privince;
	
  	 
    private  String city;
	
  	 
    private  String address;
	
  	 
    private  String contactsName;
	
  	 
    private  String contactsPost;
	
  	 
    private  String contactsPhone;
	
  	 
    private  String internalRemark;
	
  	 
    private  String suditorRemark;
	
  	 
    private  Long activityStartTime;
	
  	 
    private  Long activityEndTime;
	
  	 
    private  String status;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;
	
  	 
    private  Long updateAt;
	
  	 
    private  Long createAt;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "attribute")
	public String getAttribute() {
		return attribute;
	}
	
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
		 	@Column(name = "latitude")
	public String getLatitude() {
		return latitude;
	}
	
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
		 	@Column(name = "longitude")
	public String getLongitude() {
		return longitude;
	}
	
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
		 	@Column(name = "privince")
	public String getPrivince() {
		return privince;
	}
	
	
	public void setPrivince(String privince) {
		this.privince = privince;
	}
		 	@Column(name = "city")
	public String getCity() {
		return city;
	}
	
	
	public void setCity(String city) {
		this.city = city;
	}
		 	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
		 	@Column(name = "contacts_name")
	public String getContactsName() {
		return contactsName;
	}
	
	
	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}
		 	@Column(name = "contacts_post")
	public String getContactsPost() {
		return contactsPost;
	}
	
	
	public void setContactsPost(String contactsPost) {
		this.contactsPost = contactsPost;
	}
		 	@Column(name = "contacts_phone")
	public String getContactsPhone() {
		return contactsPhone;
	}
	
	
	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}
		 	@Column(name = "internal_remark")
	public String getInternalRemark() {
		return internalRemark;
	}
	
	
	public void setInternalRemark(String internalRemark) {
		this.internalRemark = internalRemark;
	}
		 	@Column(name = "suditor_remark")
	public String getSuditorRemark() {
		return suditorRemark;
	}
	
	
	public void setSuditorRemark(String suditorRemark) {
		this.suditorRemark = suditorRemark;
	}
		 	@Column(name = "activity_start_time")
	public Long getActivityStartTime() {
		return activityStartTime;
	}
	
	
	public void setActivityStartTime(Long activityStartTime) {
		this.activityStartTime = activityStartTime;
	}
		 	@Column(name = "activity_end_time")
	public Long getActivityEndTime() {
		return activityEndTime;
	}
	
	
	public void setActivityEndTime(Long activityEndTime) {
		this.activityEndTime = activityEndTime;
	}
		 	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
		 	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
		 	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}
	
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

