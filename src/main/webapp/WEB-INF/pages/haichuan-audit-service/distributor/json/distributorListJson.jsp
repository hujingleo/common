<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${distributorList}" var="distributor">
			<json:object>
					
               
                    <json:property name="id" value="${distributor.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="companyName" value="${distributor.companyName}"></json:property>
           
           
	   
        			
               
                    <json:property name="companyShortName" value="${distributor.companyShortName}"></json:property>
           
           
	   
        			
               
                    <json:property name="privince" value="${distributor.privince}"></json:property>
           
           
	   
        			
               
                    <json:property name="city" value="${distributor.city}"></json:property>
           
           
	   
        			
               
                    <json:property name="contactsName" value="${distributor.contactsName}"></json:property>
           
           
	   
        			
               
                    <json:property name="contactsPost" value="${distributor.contactsPost}"></json:property>
           
           
	   
        			
               
                    <json:property name="contactsPhone" value="${distributor.contactsPhone}"></json:property>
           
           
	   
        			
               
                    <json:property name="internalRemark" value="${distributor.internalRemark}"></json:property>
           
           
	   
        			
               
                    <json:property name="suditorRemark" value="${distributor.suditorRemark}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${distributor.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${distributor.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${distributor.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${distributor.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${distributor.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


