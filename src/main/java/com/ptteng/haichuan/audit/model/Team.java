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
@Table(name = "team")
public class Team implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7578180797666848768L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String name;
	
  	 
    private  String type;
	
  	 
    private  Integer count;
	
  	 
    private  Long belongToId;
	
  	 
    private  String belongToName;
	
  	 
    private  Boolean isForbidden;
	
  	 
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
		 	@Column(name = "type")
	public String getType() {
		return type;
	}
	
	
	public void setType(String type) {
		this.type = type;
	}
		 	@Column(name = "count")
	public Integer getCount() {
		return count;
	}
	
	
	public void setCount(Integer count) {
		this.count = count;
	}
		 	@Column(name = "belong_to_id")
	public Long getBelongToId() {
		return belongToId;
	}
	
	
	public void setBelongToId(Long belongToId) {
		this.belongToId = belongToId;
	}
		 	@Column(name = "belong_to_name")
	public String getBelongToName() {
		return belongToName;
	}
	
	
	public void setBelongToName(String belongToName) {
		this.belongToName = belongToName;
	}
		 	@Column(name = "is_forbidden")
	public Boolean getIsForbidden() {
		return isForbidden;
	}
	
	
	public void setIsForbidden(Boolean isForbidden) {
		this.isForbidden = isForbidden;
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

