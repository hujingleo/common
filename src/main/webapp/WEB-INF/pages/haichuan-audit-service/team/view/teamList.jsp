<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="team" id="current_nav">
<div id="teamApp" ng-app="teamApp">
	<div ng-controller="teamController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Team管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addTeam(team)">新增</span>
		    </span>
	
			<paging url="/web/a/team">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>团队名字</td>
			        				                    <td>团队属性(属于厂家还是第三方)</td>
			        				                    <td>团队队员数量</td>
			        				                    <td>团队所属厂家或第三方id</td>
			        				                    <td>团队所属厂家或第三方名字</td>
			        				                    <td>团队是否被禁用</td>
			        				                    <td>创建人ID</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="team in data">				
									                    <td ng-bind="team.id" ></td>
			        				                    <td ng-bind="team.name" ></td>
			        				                    <td ng-bind="team.type" ></td>
			        				                    <td ng-bind="team.count" ></td>
			        				                    <td ng-bind="team.belongToId" ></td>
			        				                    <td ng-bind="team.belongToName" ></td>
			        				                    <td ng-bind="team.isForbidden" ></td>
			        				                    <td ng-bind="team.createBy" ></td>
			        				                    <td ng-bind="team.updateBy" ></td>
			        				                    <td ng-bind="team.updateAt" ></td>
			        				                    <td ng-bind="team.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateTeam(team.id)" /> 
							<input type="button" value="删除" ng-click="deleteTeam(team.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/team/teamList.js"></script>
