<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="member" id="current_nav">
<div id="memberApp" ng-app="memberApp">
	<div ng-controller="memberController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Member管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addMember(member)">新增</span>
		    </span>
	
			<paging url="/web/a/member">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>队员名字</td>
			        				                    <td>队员手机号</td>
			        				                    <td>队员账号</td>
			        				                    <td>队员密码</td>
			        				                    <td>所属团队id</td>
			        				                    <td>状态是(正常0，请假1，迟到2)</td>
			        				                    <td>创建人ID</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="member in data">				
									                    <td ng-bind="member.id" ></td>
			        				                    <td ng-bind="member.name" ></td>
			        				                    <td ng-bind="member.phone" ></td>
			        				                    <td ng-bind="member.account" ></td>
			        				                    <td ng-bind="member.pwd" ></td>
			        				                    <td ng-bind="member.teamId" ></td>
			        				                    <td ng-bind="member.status" ></td>
			        				                    <td ng-bind="member.createBy" ></td>
			        				                    <td ng-bind="member.updateBy" ></td>
			        				                    <td ng-bind="member.updateAt" ></td>
			        				                    <td ng-bind="member.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateMember(member.id)" /> 
							<input type="button" value="删除" ng-click="deleteMember(member.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/member/memberList.js"></script>
