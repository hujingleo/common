<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${leave.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="memberId" value="${leave.memberId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="memberName" value="${leave.memberName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="memberPhone" value="${leave.memberPhone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="submitAt" value="${leave.submitAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="reason" value="${leave.reason}"></json:property>
           
           
	   
                    			
               
                    <json:property name="startAt" value="${leave.startAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="days" value="${leave.days}"></json:property>
           
           
	   
                    			
               
                    <json:property name="verifyStatus" value="${leave.verifyStatus}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${leave.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${leave.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${leave.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${leave.createAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


