<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="vender" id="current_nav">
	<div id="venderDetailApp" ng-app="venderDetailApp">
		<div ng-controller="venderDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="venderForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="venderId" ng-model="vender.id" ng-bind="vender.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">厂家名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="vender.name" ng-bind="vender.name" placeholder="请输入厂家名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态 (禁用0 正常1)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="vender.status" ng-bind="vender.status" placeholder="请输入状态 (禁用0 正常1)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="managerId" class="col-sm-2 control-label">登录账号ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="managerId" ng-model="vender.managerId" ng-bind="vender.managerId" placeholder="请输入登录账号ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="vender.createBy" ng-bind="vender.createBy" placeholder="请输入创建时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="vender.updateBy" ng-bind="vender.updateBy" placeholder="请输入更新时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateVender(vender)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/vender">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/vender/venderDetail.js"></script>
