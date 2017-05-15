package com.ptteng.common.search.service.impl;

import com.google.gson.Gson;
import com.ptteng.common.search.model.Param;
import com.ptteng.common.search.service.SearchService;
import com.qding.common.util.HttpClientUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;


/**
 * Created by arthur on 15/9/17.
 */
public class QingSearchServiceImpl implements SearchService {
    private static final Log log = LogFactory.getLog(QingSearchServiceImpl.class);


    private String url;
    private String params;

//    @Override
//    public String searchByParams(String url, HashMap<String,String> params, Integer start, Integer limit) {
//        BufferedReader in = null;
//
//        return result;
//    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }



    @Override
    public String getDocumentById(String index, String type, Long id) {

        if(index.isEmpty()||type.isEmpty()||id==null){
            log.info("params is null");
            return "params is null";
        }
        try {
            String requrestUrl = "http://" + this.url + "/" + index + "/" + type + "/" + id;
            String result = HttpClientUtil.sendGetRequest(requrestUrl, null);
            log.info(result);
            return result;
        }catch (Exception e){
            log.error(e);
            return "error";
        }

    }

    @Override
    public String addDocument(String index, String type, Long id, String json) {

        if(index.isEmpty()||type.isEmpty()||id==null){
            log.info("params is null");
            return "params is null";
        }
        try {
            String requrestUrl = "http://"+url+"/"+index+"/"+type+"/"+id;
            String result = HttpClientUtil.sendPutRequestByJava(requrestUrl, json);
            log.info(result);
            return result;
        }catch (Exception e){
            log.error(e);
            return "error";
        }

    }

    @Override
    public String updateDocument(String index, String type, Long id, String json) {

        if(index.isEmpty()||type.isEmpty()||id==null){
            log.info("params is null");
            return "params is null";
        }
        try {
            String requrestUrl = "http://"+url+"/"+index+"/"+type+"/"+id;
            String result = HttpClientUtil.sendPutRequestByJava(requrestUrl, json);
            log.info(result);
            return result;
        }catch (Exception e){
            log.error(e);
            return "error";
        }

    }

    @Override
    public String deleteDocument(String index, String type, Long id) {

        if(index.isEmpty()||type.isEmpty()||id==null){
            log.info("params is null");
            return "params is null";
        }
        try {
            String requrestUrl = "http://"+url+"/"+index+"/"+type+"/"+id;
            String result = HttpClientUtil.sendDeleteRequestByJava(requrestUrl);
            log.info(result);
            return result;
        }catch (Exception e){
            log.error(e);
            return "error";
        }

    }

    @Override
    public String simpleSearch(String index, String type, String query) {

        if(index.isEmpty()||type.isEmpty()){
            log.info("params is null");
            return "params is null";
        }

        try {
            params = query;
//            Param param = new Param();
//            param.setFrom(from);
//            param.setSize(size);
//            param.setSort(sort);
//            param.setQuery("{\"term\":{"+query+"}}");
//            Gson gson = new Gson();
//            String params = gson.toJson(param);
            log.info("params is : "+params);
            String requrestUrl = "http://"+url+"/"+index+"/"+type+"/_search";
            log.info("url is :"+requrestUrl);
            String result = HttpClientUtil.sendPostRequestByJava(requrestUrl, params);
            log.info(result);
            return result;
        }catch (Exception e){
            log.error(e);
            return "error";
        }
    }

    @Override
    public String indexSearch(String index, String query) {
        if(index.isEmpty()){
            log.info("params is null");
            return "params is null";
        }

        try {
            params = query;
//            Param param = new Param();
//            param.setFrom(from);
//            param.setSize(size);
//            param.setSort(sort);
//            param.setQuery("{\"term\":{"+query+"}}");
//            Gson gson = new Gson();
//            String params = gson.toJson(param);
            log.info("params is : "+params);
            String requrestUrl = "http://"+url+"/"+index+"/_search";
            log.info("url is :"+requrestUrl);
            String result = HttpClientUtil.sendPostRequestByJava(requrestUrl, params);
            log.info(result);
            return result;
        }catch (Exception e){
            log.error(e);
            return "error";
        }
    }


    @Override
    public String addIndex(String index) {
        if(index.isEmpty()){
            log.info("params is null");
            return "params is null";
        }

        try {

            String requrestUrl = "http://"+url+"/"+index+"/";
            log.info("url is :"+requrestUrl);
            String result = HttpClientUtil.sendPutRequestByJava(requrestUrl,null);
            log.info(result);
            return result;
        }catch (Exception e){
            log.error(e);
            return "error";
        }
    }


    public static void main(String[] args) {

    }
}

