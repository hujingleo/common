<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="late" id="current_nav">
	<div id="lateDetailApp" ng-app="lateDetailApp">
		<div ng-controller="lateDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="lateForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="lateId" ng-model="late.id" ng-bind="late.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberId" class="col-sm-2 control-label">队员id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberId" ng-model="late.memberId" ng-bind="late.memberId" placeholder="请输入队员id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="taskId" class="col-sm-2 control-label">任务id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="taskId" ng-model="late.taskId" ng-bind="late.taskId" placeholder="请输入任务id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="taskStorage" class="col-sm-2 control-label">任务对应库位</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="taskStorage" ng-model="late.taskStorage" ng-bind="late.taskStorage" placeholder="请输入任务对应库位" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberName" class="col-sm-2 control-label">队员名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberName" ng-model="late.memberName" ng-bind="late.memberName" placeholder="请输入队员名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberPhone" class="col-sm-2 control-label">队员手机号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberPhone" ng-model="late.memberPhone" ng-bind="late.memberPhone" placeholder="请输入队员手机号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="dealerId" class="col-sm-2 control-label">经销商id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="dealerId" ng-model="late.dealerId" ng-bind="late.dealerId" placeholder="请输入经销商id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="submitAt" class="col-sm-2 control-label">迟到申请时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="submitAt" ng-model="late.submitAt" ng-bind="late.submitAt" placeholder="请输入迟到申请时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="taskAt" class="col-sm-2 control-label">任务计划开始时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="taskAt" ng-model="late.taskAt" ng-bind="late.taskAt" placeholder="请输入任务计划开始时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="arriveAt" class="col-sm-2 control-label">实际到场时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="arriveAt" ng-model="late.arriveAt" ng-bind="late.arriveAt" placeholder="请输入实际到场时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="imgUrl" class="col-sm-2 control-label">现场照片url</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="imgUrl" ng-model="late.imgUrl" ng-bind="late.imgUrl" placeholder="请输入现场照片url" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="reason" class="col-sm-2 control-label">迟到原因</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="reason" ng-model="late.reason" ng-bind="late.reason" placeholder="请输入迟到原因" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="verifyStatus" class="col-sm-2 control-label">申请状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="verifyStatus" ng-model="late.verifyStatus" ng-bind="late.verifyStatus" placeholder="请输入申请状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="late.createBy" ng-bind="late.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="late.updateBy" ng-bind="late.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateLate(late)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/late">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/late/lateDetail.js"></script>
