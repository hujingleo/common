<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="member" id="current_nav">
	<div id="memberDetailApp" ng-app="memberDetailApp">
		<div ng-controller="memberDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="memberForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="memberId" ng-model="member.id" ng-bind="member.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">队员名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="member.name" ng-bind="member.name" placeholder="请输入队员名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="phone" class="col-sm-2 control-label">队员手机号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="phone" ng-model="member.phone" ng-bind="member.phone" placeholder="请输入队员手机号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="account" class="col-sm-2 control-label">队员账号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="account" ng-model="member.account" ng-bind="member.account" placeholder="请输入队员账号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="pwd" class="col-sm-2 control-label">队员密码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="pwd" ng-model="member.pwd" ng-bind="member.pwd" placeholder="请输入队员密码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="teamId" class="col-sm-2 control-label">所属团队id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="teamId" ng-model="member.teamId" ng-bind="member.teamId" placeholder="请输入所属团队id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态是(正常0，请假1，迟到2)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="member.status" ng-bind="member.status" placeholder="请输入状态是(正常0，请假1，迟到2)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="member.createBy" ng-bind="member.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="member.updateBy" ng-bind="member.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateMember(member)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/member">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/member/memberDetail.js"></script>
