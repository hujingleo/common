'use strict';
angular.module('haichuan_audit')
    .controller('leaveCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, leaveService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     memberId: $state.params.memberId
	                              ,  
                     	     memberName: $state.params.memberName
	                              ,  
                     	     memberPhone: $state.params.memberPhone
	                              ,  
                     	     submitAt: $state.params.submitAt
	                              ,  
                     	     reason: $state.params.reason
	                              ,  
                     	     startAt: $state.params.startAt
	                	     days: $state.params.days
	                	     verifyStatus: $state.params.verifyStatus
	                	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                	     updateAt: $state.params.updateAt
	                	     createAt: $state.params.createAt
	                         };


    leaveService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.leaveList", vm.params,{reload:true});
    };
    });
