'use strict';
angular.module('haichuan_audit')
    .controller('lateCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, lateService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     memberId: $state.params.memberId
	                              ,  
                     	     taskId: $state.params.taskId
	                              ,  
                     	     taskStorage: $state.params.taskStorage
	                              ,  
                     	     memberName: $state.params.memberName
	                              ,  
                     	     memberPhone: $state.params.memberPhone
	                              ,  
                     	     dealerId: $state.params.dealerId
	                	     submitAt: $state.params.submitAt
	                	     taskAt: $state.params.taskAt
	                	     arriveAt: $state.params.arriveAt
	                	     imgUrl: $state.params.imgUrl
	                	     reason: $state.params.reason
	                	     verifyStatus: $state.params.verifyStatus
	                	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                	     updateAt: $state.params.updateAt
	                	     createAt: $state.params.createAt
	                         };


    lateService.getList(vm.params).then(function(res) {
        if (res.data.code === 0) {
            vm.list = res.data.data;
            vm.page = {
                next: res.data.next || 0,
                size: res.data.size || 0,
                page: res.data.page || 0,
                total: res.data.total || 0
            };
        } else {
            $rootScope.alert(res.data.message);
        }
    });
  

    vm.search = function() {
        
        $state.go("field.lateList", vm.params,{reload:true});
    };
    });
