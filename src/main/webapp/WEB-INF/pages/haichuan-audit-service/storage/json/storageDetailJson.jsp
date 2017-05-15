<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${storage.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${storage.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="attribute" value="${storage.attribute}"></json:property>
           
           
	   
                    			
               
                    <json:property name="latitude" value="${storage.latitude}"></json:property>
           
           
	   
                    			
               
                    <json:property name="longitude" value="${storage.longitude}"></json:property>
           
           
	   
                    			
               
                    <json:property name="privince" value="${storage.privince}"></json:property>
           
           
	   
                    			
               
                    <json:property name="city" value="${storage.city}"></json:property>
           
           
	   
                    			
               
                    <json:property name="address" value="${storage.address}"></json:property>
           
           
	   
                    			
               
                    <json:property name="contactsName" value="${storage.contactsName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="contactsPost" value="${storage.contactsPost}"></json:property>
           
           
	   
                    			
               
                    <json:property name="contactsPhone" value="${storage.contactsPhone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="internalRemark" value="${storage.internalRemark}"></json:property>
           
           
	   
                    			
               
                    <json:property name="suditorRemark" value="${storage.suditorRemark}"></json:property>
           
           
	   
                    			
               
                    <json:property name="activityStartTime" value="${storage.activityStartTime}"></json:property>
           
           
	   
                    			
               
                    <json:property name="activityEndTime" value="${storage.activityEndTime}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${storage.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${storage.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${storage.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${storage.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${storage.createAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


