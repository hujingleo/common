'use strict';
angular.module('haichuan_audit')
    .controller('distributorCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, distributorService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     companyName: $state.params.companyName
	                              ,  
                     	     companyShortName: $state.params.companyShortName
	                              ,  
                     	     privince: $state.params.privince
	                              ,  
                     	     city: $state.params.city
	                              ,  
                     	     contactsName: $state.params.contactsName
	                              ,  
                     	     contactsPost: $state.params.contactsPost
	                	     contactsPhone: $state.params.contactsPhone
	                	     internalRemark: $state.params.internalRemark
	                	     suditorRemark: $state.params.suditorRemark
	                	     status: $state.params.status
	                	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                	     updateAt: $state.params.updateAt
	                	     createAt: $state.params.createAt
	                         };


    distributorService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.distributorList", vm.params,{reload:true});
    };
    });
