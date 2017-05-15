<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="team" id="current_nav">
	<div id="teamDetailApp" ng-app="teamDetailApp">
		<div ng-controller="teamDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="teamForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="teamId" ng-model="team.id" ng-bind="team.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">团队名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="team.name" ng-bind="team.name" placeholder="请输入团队名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="type" class="col-sm-2 control-label">团队属性(属于厂家还是第三方)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="type" ng-model="team.type" ng-bind="team.type" placeholder="请输入团队属性(属于厂家还是第三方)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="count" class="col-sm-2 control-label">团队队员数量</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="count" ng-model="team.count" ng-bind="team.count" placeholder="请输入团队队员数量" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="belongToId" class="col-sm-2 control-label">团队所属厂家或第三方id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="belongToId" ng-model="team.belongToId" ng-bind="team.belongToId" placeholder="请输入团队所属厂家或第三方id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="belongToName" class="col-sm-2 control-label">团队所属厂家或第三方名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="belongToName" ng-model="team.belongToName" ng-bind="team.belongToName" placeholder="请输入团队所属厂家或第三方名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="isForbidden" class="col-sm-2 control-label">团队是否被禁用</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="isForbidden" ng-model="team.isForbidden" ng-bind="team.isForbidden" placeholder="请输入团队是否被禁用" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="team.createBy" ng-bind="team.createBy" placeholder="请输入创建人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="team.updateBy" ng-bind="team.updateBy" placeholder="请输入更新人ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateTeam(team)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/team">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/haichuan-audit-service/team/teamDetail.js"></script>
