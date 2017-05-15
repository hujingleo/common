'use strict';
angular.module('haichuan_audit')
    .controller('teamCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, teamService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     type: $state.params.type
	                              ,  
                     	     count: $state.params.count
	                              ,  
                     	     belongToId: $state.params.belongToId
	                              ,  
                     	     belongToName: $state.params.belongToName
	                              ,  
                     	     isForbidden: $state.params.isForbidden
	                	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                	     updateAt: $state.params.updateAt
	                	     createAt: $state.params.createAt
	                         };


    teamService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.teamList", vm.params,{reload:true});
    };
    });
