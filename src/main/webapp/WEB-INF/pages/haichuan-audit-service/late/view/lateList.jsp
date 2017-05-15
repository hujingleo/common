<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="late" id="current_nav">
<div id="lateApp" ng-app="lateApp">
	<div ng-controller="lateController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Late管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addLate(late)">新增</span>
		    </span>
	
			<paging url="/web/a/late">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>队员id</td>
			        				                    <td>任务id</td>
			        				                    <td>任务对应库位</td>
			        				                    <td>队员名字</td>
			        				                    <td>队员手机号</td>
			        				                    <td>经销商id</td>
			        				                    <td>迟到申请时间</td>
			        				                    <td>任务计划开始时间</td>
			        				                    <td>实际到场时间</td>
			        				                    <td>现场照片url</td>
			        				                    <td>迟到原因</td>
			        				                    <td>申请状态</td>
			        				                    <td>创建人ID</td>
			        				                    <td>更新人ID</td>
			        				                    <td>数据更新时间</td>
			        				                    <td>数据创建时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="late in data">				
									                    <td ng-bind="late.id" ></td>
			        				                    <td ng-bind="late.memberId" ></td>
			        				                    <td ng-bind="late.taskId" ></td>
			        				                    <td ng-bind="late.taskStorage" ></td>
			        				                    <td ng-bind="late.memberName" ></td>
			        				                    <td ng-bind="late.memberPhone" ></td>
			        				                    <td ng-bind="late.dealerId" ></td>
			        				                    <td ng-bind="late.submitAt" ></td>
			        				                    <td ng-bind="late.taskAt" ></td>
			        				                    <td ng-bind="late.arriveAt" ></td>
			        				                    <td ng-bind="late.imgUrl" ></td>
			        				                    <td ng-bind="late.reason" ></td>
			        				                    <td ng-bind="late.verifyStatus" ></td>
			        				                    <td ng-bind="late.createBy" ></td>
			        				                    <td ng-bind="late.updateBy" ></td>
			        				                    <td ng-bind="late.updateAt" ></td>
			        				                    <td ng-bind="late.createAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateLate(late.id)" /> 
							<input type="button" value="删除" ng-click="deleteLate(late.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/haichuan-audit-service/late/lateList.js"></script>
