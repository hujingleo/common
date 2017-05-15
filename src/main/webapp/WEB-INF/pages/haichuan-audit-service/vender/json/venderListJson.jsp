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
		<c:forEach items="${venderList}" var="vender">
			<json:object>
					
               
                    <json:property name="id" value="${vender.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${vender.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="status" value="${vender.status}"></json:property>
           
           
	   
        			
               
                    <json:property name="managerId" value="${vender.managerId}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${vender.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${vender.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${vender.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${vender.createAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


