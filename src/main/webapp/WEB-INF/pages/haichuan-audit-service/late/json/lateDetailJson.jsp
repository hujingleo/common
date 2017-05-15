<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${late.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="memberId" value="${late.memberId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="taskId" value="${late.taskId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="taskStorage" value="${late.taskStorage}"></json:property>
           
           
	   
                    			
               
                    <json:property name="memberName" value="${late.memberName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="memberPhone" value="${late.memberPhone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="dealerId" value="${late.dealerId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="submitAt" value="${late.submitAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="taskAt" value="${late.taskAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="arriveAt" value="${late.arriveAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="imgUrl" value="${late.imgUrl}"></json:property>
           
           
	   
                    			
               
                    <json:property name="reason" value="${late.reason}"></json:property>
           
           
	   
                    			
               
                    <json:property name="verifyStatus" value="${late.verifyStatus}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${late.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${late.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${late.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${late.createAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


