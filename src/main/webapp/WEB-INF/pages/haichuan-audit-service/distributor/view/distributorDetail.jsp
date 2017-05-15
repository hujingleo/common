<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="distributor" id="current_nav">
	<div id="distributorDetailApp" ng-app="distributorDetailApp">
		<div ng-controller="distributorDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="distributorForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="distributorId" ng-model="distributor.id" ng-bind="distributor.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="companyName" class="col-sm-2 control-label">公司名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="companyName" ng-model="distributor.companyName" ng-bind="distributor.companyName" placeholder="请输入公司名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="companyShortName" class="col-sm-2 control-label">公司简称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="companyShortName" ng-model="distributor.companyShortName" ng-bind="distributor.companyShortName" placeholder="请输入公司简称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="privince" class="col-sm-2 control-label">省</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="privince" ng-model="distributor.privince" ng-bind="distributor.privince" placeholder="请输入省" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="city" class="col-sm-2 control-label">市</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="city" ng-model="distributor.city" ng-bind="distributor.city" placeholder="请输入市" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="contactsName" class="col-sm-2 control-label">联系人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="contactsName" ng-model="distributor.contactsName" ng-bind="distributor.contactsName" placeholder="请输入联系人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="contactsPost" class="col-sm-2 control-label">联系人岗位</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="contactsPost" ng-model="distributor.contactsPost" ng-bind="distributor.contactsPost" placeholder="请输入联系人岗位" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="contactsPhone" class="col-sm-2 control-label">联系人电话</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="contactsPhone" ng-model="distributor.contactsPhone" ng-bind="distributor.contactsPhone" placeholder="请输入联系人电话" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="internalRemark" class="col-sm-2 control-label">内部备注</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="internalRemark" ng-model="distributor.internalRemark" ng-bind="distributor.internalRemark" placeholder="请输入内部备注" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="suditorRemark" class="col-sm-2 control-label">审计员备注</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="suditorRemark" ng-model="distributor.suditorRemark" ng-bind="distributor.suditorRemark" placeholder="请输入审计员备注" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态 (1正常0禁用)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="distributor.status" ng-bind="distributor.status" placeholder="请输入状态 (1正常0禁用)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="distributor.createBy" ng-bind="distributor.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="distributor.updateBy" ng-bind="distributor.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateDistributor(distributor)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/distributor">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/distributor/distributorDetail.js"></script>
