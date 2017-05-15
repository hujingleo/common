'use strict';
angular.module('carrots_replay')

    .factory('pathProject', function (commonUtil) {
        return {
                	     article: function (id) {
                if (!id) {
                    return "ajax/u/article";
                } else {
                    return "ajax/u/article/" + id;
                }
            },
          article_list: "ajax/u/article/search"
          
                        
          
         
         
        }
    })
    
           
	    .factory('articleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.article(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.article(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.article_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.article(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.article(id));
            }
           
        }
    })
             
   
    ;






