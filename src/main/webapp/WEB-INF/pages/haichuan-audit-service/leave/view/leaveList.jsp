<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="leave" id="current_nav">
<div id="leaveApp" ng-app="leaveApp">
	<div ng-controller="leaveController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Leave管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addLeave(leave)">新增</span>
		    </span>
	
			<paging url="/web/a/leave">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>队员id</td>
			        				                    <td>队员姓名</td>
			        				                    <td>队员手机号</td>
			        				                    <td>请假申请提交时间</td>
			        				                    <td>请假原因</td>
			        				                    <td>假期开始时间</td>
			        				                    <td>请假天数</td>
			        				                    <td>申请状态（申请中、通过、拒绝）</td>
			        				                    <td>创建人ID</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="leave in data">				
									                    <td ng-bind="leave.id" ></td>
			        				                    <td ng-bind="leave.memberId" ></td>
			        				                    <td ng-bind="leave.memberName" ></td>
			        				                    <td ng-bind="leave.memberPhone" ></td>
			        				                    <td ng-bind="leave.submitAt" ></td>
			        				                    <td ng-bind="leave.reason" ></td>
			        				                    <td ng-bind="leave.startAt" ></td>
			        				                    <td ng-bind="leave.days" ></td>
			        				                    <td ng-bind="leave.verifyStatus" ></td>
			        				                    <td ng-bind="leave.createBy" ></td>
			        				                    <td ng-bind="leave.updateBy" ></td>
			        				                    <td ng-bind="leave.updateAt" ></td>
			        				                    <td ng-bind="leave.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateLeave(leave.id)" /> 
							<input type="button" value="删除" ng-click="deleteLeave(leave.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/leave/leaveList.js"></script>
