package com.qding.community.common.weixin.vo.template.message;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.qding.community.common.weixin.vo.template.TemplateEntry;

public class MessageReply implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6641720966460803041L;

	private TemplateEntry first;	
	private TemplateEntry keyword1;
	private TemplateEntry keyword2;
	private TemplateEntry keyword3;
	private TemplateEntry remark;
	
	
	public TemplateEntry getFirst() {
		return first;
	}








	public void setFirst(TemplateEntry first) {
		this.first = first;
	}








	public TemplateEntry getKeyword1() {
		return keyword1;
	}








	public void setKeyword1(TemplateEntry keyword1) {
		this.keyword1 = keyword1;
	}








	public TemplateEntry getKeyword2() {
		return keyword2;
	}








	public void setKeyword2(TemplateEntry keyword2) {
		this.keyword2 = keyword2;
	}








	public TemplateEntry getKeyword3() {
		return keyword3;
	}








	public void setKeyword3(TemplateEntry keyword3) {
		this.keyword3 = keyword3;
	}








	public TemplateEntry getRemark() {
		return remark;
	}








	public void setRemark(TemplateEntry remark) {
		this.remark = remark;
	}






	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
