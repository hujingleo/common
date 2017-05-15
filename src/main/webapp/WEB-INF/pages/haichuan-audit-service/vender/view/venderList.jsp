<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="vender" id="current_nav">
<div id="venderApp" ng-app="venderApp">
	<div ng-controller="venderController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Vender管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addVender(vender)">新增</span>
		    </span>
	
			<paging url="/web/a/vender">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>厂家名称</td>
			        				                    <td>状态 (禁用0 正常1)</td>
			        				                    <td>登录账号ID</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="vender in data">				
									                    <td ng-bind="vender.id" ></td>
			        				                    <td ng-bind="vender.name" ></td>
			        				                    <td ng-bind="vender.status" ></td>
			        				                    <td ng-bind="vender.managerId" ></td>
			        				                    <td ng-bind="vender.createBy" ></td>
			        				                    <td ng-bind="vender.updateBy" ></td>
			        				                    <td ng-bind="vender.updateAt" ></td>
			        				                    <td ng-bind="vender.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateVender(vender.id)" /> 
							<input type="button" value="删除" ng-click="deleteVender(vender.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/vender/venderList.js"></script>
