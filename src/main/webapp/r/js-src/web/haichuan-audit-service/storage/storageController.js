'use strict';
angular.module('haichuan_audit')
    .controller('storageCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, storageService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     attribute: $state.params.attribute
	                              ,  
                     	     latitude: $state.params.latitude
	                              ,  
                     	     longitude: $state.params.longitude
	                              ,  
                     	     privince: $state.params.privince
	                              ,  
                     	     city: $state.params.city
	                	     address: $state.params.address
	                	     contactsName: $state.params.contactsName
	                	     contactsPost: $state.params.contactsPost
	                	     contactsPhone: $state.params.contactsPhone
	                	     internalRemark: $state.params.internalRemark
	                	     suditorRemark: $state.params.suditorRemark
	                	     activityStartTime: $state.params.activityStartTime
	                	     activityEndTime: $state.params.activityEndTime
	                	     status: $state.params.status
	                	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                	     updateAt: $state.params.updateAt
	                	     createAt: $state.params.createAt
	                         };


    storageService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.storageList", vm.params,{reload:true});
    };
    });
