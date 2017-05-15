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
@Table(name = "late")
public class Late implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 721730575894265856L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long memberId;
	
  	 
    private  Integer taskId;
	
  	 
    private  String taskStorage;
	
  	 
    private  String memberName;
	
  	 
    private  Long memberPhone;
	
  	 
    private  Long dealerId;
	
  	 
    private  Long submitAt;
	
  	 
    private  Long taskAt;
	
  	 
    private  Long arriveAt;
	
  	 
    private  String imgUrl;
	
  	 
    private  String reason;
	
  	 
    private  Integer verifyStatus;
	
  	 
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
		 	@Column(name = "member_id")
	public Long getMemberId() {
		return memberId;
	}
	
	
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
		 	@Column(name = "task_id")
	public Integer getTaskId() {
		return taskId;
	}
	
	
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
		 	@Column(name = "task_storage")
	public String getTaskStorage() {
		return taskStorage;
	}
	
	
	public void setTaskStorage(String taskStorage) {
		this.taskStorage = taskStorage;
	}
		 	@Column(name = "member_name")
	public String getMemberName() {
		return memberName;
	}
	
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
		 	@Column(name = "member_phone")
	public Long getMemberPhone() {
		return memberPhone;
	}
	
	
	public void setMemberPhone(Long memberPhone) {
		this.memberPhone = memberPhone;
	}
		 	@Column(name = "dealer_id")
	public Long getDealerId() {
		return dealerId;
	}
	
	
	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}
		 	@Column(name = "submit_at")
	public Long getSubmitAt() {
		return submitAt;
	}
	
	
	public void setSubmitAt(Long submitAt) {
		this.submitAt = submitAt;
	}
		 	@Column(name = "task_at")
	public Long getTaskAt() {
		return taskAt;
	}
	
	
	public void setTaskAt(Long taskAt) {
		this.taskAt = taskAt;
	}
		 	@Column(name = "arrive_at")
	public Long getArriveAt() {
		return arriveAt;
	}
	
	
	public void setArriveAt(Long arriveAt) {
		this.arriveAt = arriveAt;
	}
		 	@Column(name = "img_url")
	public String getImgUrl() {
		return imgUrl;
	}
	
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
		 	@Column(name = "reason")
	public String getReason() {
		return reason;
	}
	
	
	public void setReason(String reason) {
		this.reason = reason;
	}
		 	@Column(name = "verify_status")
	public Integer getVerifyStatus() {
		return verifyStatus;
	}
	
	
	public void setVerifyStatus(Integer verifyStatus) {
		this.verifyStatus = verifyStatus;
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

