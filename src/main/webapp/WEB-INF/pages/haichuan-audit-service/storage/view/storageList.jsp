<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="storage" id="current_nav">
<div id="storageApp" ng-app="storageApp">
	<div ng-controller="storageController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Storage管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addStorage(storage)">新增</span>
		    </span>
	
			<paging url="/web/a/storage">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>库位名称</td>
			        				                    <td>属性 (1本部库位、2二网库位、3临展库位)</td>
			        				                    <td>经度</td>
			        				                    <td>纬度</td>
			        				                    <td>省</td>
			        				                    <td>市</td>
			        				                    <td>详细地址</td>
			        				                    <td>联系人</td>
			        				                    <td>联系人岗位</td>
			        				                    <td>联系人电话</td>
			        				                    <td>内部备注</td>
			        				                    <td>审计员备注</td>
			        				                    <td>活动开始时间 (当属性为临展车位时使用)</td>
			        				                    <td>活动结束时间 (当属性为临展车位时使用)</td>
			        				                    <td>状态 (1正常0禁用)</td>
			        				                    <td>创建人ID</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="storage in data">				
									                    <td ng-bind="storage.id" ></td>
			        				                    <td ng-bind="storage.name" ></td>
			        				                    <td ng-bind="storage.attribute" ></td>
			        				                    <td ng-bind="storage.latitude" ></td>
			        				                    <td ng-bind="storage.longitude" ></td>
			        				                    <td ng-bind="storage.privince" ></td>
			        				                    <td ng-bind="storage.city" ></td>
			        				                    <td ng-bind="storage.address" ></td>
			        				                    <td ng-bind="storage.contactsName" ></td>
			        				                    <td ng-bind="storage.contactsPost" ></td>
			        				                    <td ng-bind="storage.contactsPhone" ></td>
			        				                    <td ng-bind="storage.internalRemark" ></td>
			        				                    <td ng-bind="storage.suditorRemark" ></td>
			        				                    <td ng-bind="storage.activityStartTime" ></td>
			        				                    <td ng-bind="storage.activityEndTime" ></td>
			        				                    <td ng-bind="storage.status" ></td>
			        				                    <td ng-bind="storage.createBy" ></td>
			        				                    <td ng-bind="storage.updateBy" ></td>
			        				                    <td ng-bind="storage.updateAt" ></td>
			        				                    <td ng-bind="storage.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateStorage(storage.id)" /> 
							<input type="button" value="删除" ng-click="deleteStorage(storage.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/storage/storageList.js"></script>
