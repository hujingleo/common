<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="distributor" id="current_nav">
<div id="distributorApp" ng-app="distributorApp">
	<div ng-controller="distributorController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Distributor管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDistributor(distributor)">新增</span>
		    </span>
	
			<paging url="/web/a/distributor">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>公司名称</td>
			        				                    <td>公司简称</td>
			        				                    <td>省</td>
			        				                    <td>市</td>
			        				                    <td>联系人</td>
			        				                    <td>联系人岗位</td>
			        				                    <td>联系人电话</td>
			        				                    <td>内部备注</td>
			        				                    <td>审计员备注</td>
			        				                    <td>状态 (1正常0禁用)</td>
			        				                    <td>创建人ID</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="distributor in data">				
									                    <td ng-bind="distributor.id" ></td>
			        				                    <td ng-bind="distributor.companyName" ></td>
			        				                    <td ng-bind="distributor.companyShortName" ></td>
			        				                    <td ng-bind="distributor.privince" ></td>
			        				                    <td ng-bind="distributor.city" ></td>
			        				                    <td ng-bind="distributor.contactsName" ></td>
			        				                    <td ng-bind="distributor.contactsPost" ></td>
			        				                    <td ng-bind="distributor.contactsPhone" ></td>
			        				                    <td ng-bind="distributor.internalRemark" ></td>
			        				                    <td ng-bind="distributor.suditorRemark" ></td>
			        				                    <td ng-bind="distributor.status" ></td>
			        				                    <td ng-bind="distributor.createBy" ></td>
			        				                    <td ng-bind="distributor.updateBy" ></td>
			        				                    <td ng-bind="distributor.updateAt" ></td>
			        				                    <td ng-bind="distributor.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDistributor(distributor.id)" /> 
							<input type="button" value="删除" ng-click="deleteDistributor(distributor.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/distributor/distributorList.js"></script>
