'use strict';
angular.module('haichuan_audit')

    .factory('pathProject', function (commonUtil) {
        return {
                	     storage: function (id) {
                if (!id) {
                    return "ajax/u/storage";
                } else {
                    return "ajax/u/storage/" + id;
                }
            },
          storage_list: "ajax/u/storage/search"
          
                                   ,  
                        
          
         
         	     storage: function (id) {
                if (!id) {
                    return "ajax/u/storage";
                } else {
                    return "ajax/u/storage/" + id;
                }
            },
          storage_list: "ajax/u/storage/search"
          
                                   ,  
                        
          
         
         	     storage: function (id) {
                if (!id) {
                    return "ajax/u/storage";
                } else {
                    return "ajax/u/storage/" + id;
                }
            },
          storage_list: "ajax/u/storage/search"
          
                                   ,  
                        
          
         
         	     storage: function (id) {
                if (!id) {
                    return "ajax/u/storage";
                } else {
                    return "ajax/u/storage/" + id;
                }
            },
          storage_list: "ajax/u/storage/search"
          
                                   ,  
                        
          
         
         	     storage: function (id) {
                if (!id) {
                    return "ajax/u/storage";
                } else {
                    return "ajax/u/storage/" + id;
                }
            },
          storage_list: "ajax/u/storage/search"
          
                                   ,  
                        
          
         
         	     storage: function (id) {
                if (!id) {
                    return "ajax/u/storage";
                } else {
                    return "ajax/u/storage/" + id;
                }
            },
          storage_list: "ajax/u/storage/search"
          
                                   ,  
                        
          
         
         	     storage: function (id) {
                if (!id) {
                    return "ajax/u/storage";
                } else {
                    return "ajax/u/storage/" + id;
                }
            },
          storage_list: "ajax/u/storage/search"
          
                        
          
         
         
        }
    })
    
           
	    .factory('teamService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.team(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.team(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.team_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.team(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.team(id));
            }
           
        }
    })
                
	    .factory('memberService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.member(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.member(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.member_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.member(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.member(id));
            }
           
        }
    })
                
	    .factory('leaveService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.leave(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.leave(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.leave_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.leave(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.leave(id));
            }
           
        }
    })
                
	    .factory('lateService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.late(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.late(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.late_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.late(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.late(id));
            }
           
        }
    })
                
	    .factory('venderService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.vender(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.vender(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.vender_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.vender(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.vender(id));
            }
           
        }
    })
                
	    .factory('distributorService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.distributor(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.distributor(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.distributor_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.distributor(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.distributor(id));
            }
           
        }
    })
                
	    .factory('storageService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.storage(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.storage(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.storage_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.storage(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.storage(id));
            }
           
        }
    })
             
   
    ;






