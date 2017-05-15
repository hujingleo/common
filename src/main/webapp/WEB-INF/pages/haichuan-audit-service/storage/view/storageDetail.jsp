<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="storage" id="current_nav">
	<div id="storageDetailApp" ng-app="storageDetailApp">
		<div ng-controller="storageDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="storageForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="storageId" ng-model="storage.id" ng-bind="storage.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">库位名称</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="storage.name" ng-bind="storage.name" placeholder="请输入库位名称" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="attribute" class="col-sm-2 control-label">属性 (1本部库位、2二网库位、3临展库位)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="attribute" ng-model="storage.attribute" ng-bind="storage.attribute" placeholder="请输入属性 (1本部库位、2二网库位、3临展库位)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="latitude" class="col-sm-2 control-label">经度</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="latitude" ng-model="storage.latitude" ng-bind="storage.latitude" placeholder="请输入经度" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="longitude" class="col-sm-2 control-label">纬度</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="longitude" ng-model="storage.longitude" ng-bind="storage.longitude" placeholder="请输入纬度" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="privince" class="col-sm-2 control-label">省</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="privince" ng-model="storage.privince" ng-bind="storage.privince" placeholder="请输入省" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="city" class="col-sm-2 control-label">市</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="city" ng-model="storage.city" ng-bind="storage.city" placeholder="请输入市" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="address" class="col-sm-2 control-label">详细地址</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="address" ng-model="storage.address" ng-bind="storage.address" placeholder="请输入详细地址" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="contactsName" class="col-sm-2 control-label">联系人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="contactsName" ng-model="storage.contactsName" ng-bind="storage.contactsName" placeholder="请输入联系人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="contactsPost" class="col-sm-2 control-label">联系人岗位</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="contactsPost" ng-model="storage.contactsPost" ng-bind="storage.contactsPost" placeholder="请输入联系人岗位" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="contactsPhone" class="col-sm-2 control-label">联系人电话</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="contactsPhone" ng-model="storage.contactsPhone" ng-bind="storage.contactsPhone" placeholder="请输入联系人电话" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="internalRemark" class="col-sm-2 control-label">内部备注</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="internalRemark" ng-model="storage.internalRemark" ng-bind="storage.internalRemark" placeholder="请输入内部备注" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="suditorRemark" class="col-sm-2 control-label">审计员备注</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="suditorRemark" ng-model="storage.suditorRemark" ng-bind="storage.suditorRemark" placeholder="请输入审计员备注" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="activityStartTime" class="col-sm-2 control-label">活动开始时间 (当属性为临展车位时使用)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="activityStartTime" ng-model="storage.activityStartTime" ng-bind="storage.activityStartTime" placeholder="请输入活动开始时间 (当属性为临展车位时使用)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="activityEndTime" class="col-sm-2 control-label">活动结束时间 (当属性为临展车位时使用)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="activityEndTime" ng-model="storage.activityEndTime" ng-bind="storage.activityEndTime" placeholder="请输入活动结束时间 (当属性为临展车位时使用)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态 (1正常0禁用)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="storage.status" ng-bind="storage.status" placeholder="请输入状态 (1正常0禁用)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="storage.createBy" ng-bind="storage.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="storage.updateBy" ng-bind="storage.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateStorage(storage)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/storage">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/storage/storageDetail.js"></script>
