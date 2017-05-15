'use strict';
angular.module('haichuan_audit')
    .controller('memberCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, memberService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     phone: $state.params.phone
	                              ,  
                     	     account: $state.params.account
	                              ,  
                     	     pwd: $state.params.pwd
	                              ,  
                     	     teamId: $state.params.teamId
	                              ,  
                     	     status: $state.params.status
	                	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                	     updateAt: $state.params.updateAt
	                	     createAt: $state.params.createAt
	                         };


    memberService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.memberList", vm.params,{reload:true});
    };
    });
