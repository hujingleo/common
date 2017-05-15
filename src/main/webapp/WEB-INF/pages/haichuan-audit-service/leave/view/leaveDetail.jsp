<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="leave" id="current_nav">
	<div id="leaveDetailApp" ng-app="leaveDetailApp">
		<div ng-controller="leaveDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="leaveForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="leaveId" ng-model="leave.id" ng-bind="leave.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberId" class="col-sm-2 control-label">队员id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberId" ng-model="leave.memberId" ng-bind="leave.memberId" placeholder="请输入队员id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberName" class="col-sm-2 control-label">队员姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberName" ng-model="leave.memberName" ng-bind="leave.memberName" placeholder="请输入队员姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="memberPhone" class="col-sm-2 control-label">队员手机号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="memberPhone" ng-model="leave.memberPhone" ng-bind="leave.memberPhone" placeholder="请输入队员手机号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="submitAt" class="col-sm-2 control-label">请假申请提交时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="submitAt" ng-model="leave.submitAt" ng-bind="leave.submitAt" placeholder="请输入请假申请提交时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="reason" class="col-sm-2 control-label">请假原因</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="reason" ng-model="leave.reason" ng-bind="leave.reason" placeholder="请输入请假原因" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="startAt" class="col-sm-2 control-label">假期开始时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="startAt" ng-model="leave.startAt" ng-bind="leave.startAt" placeholder="请输入假期开始时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="days" class="col-sm-2 control-label">请假天数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="days" ng-model="leave.days" ng-bind="leave.days" placeholder="请输入请假天数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="verifyStatus" class="col-sm-2 control-label">申请状态（申请中、通过、拒绝）</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="verifyStatus" ng-model="leave.verifyStatus" ng-bind="leave.verifyStatus" placeholder="请输入申请状态（申请中、通过、拒绝）" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="leave.createBy" ng-bind="leave.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="leave.updateBy" ng-bind="leave.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateLeave(leave)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/leave">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/leave/leaveDetail.js"></script>
