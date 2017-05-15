package com.ptteng.common.storage.util;

import com.qcloud.cosapi.api.CosCloud;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import org.apache.http.config.Lookup;
import org.apache.http.entity.mime.MultipartEntityBuilder;

/**
 * Created by liangxj on 2016/7/13.
 * 腾讯云存储
 */
public class ImgStorageTencentServiceImpl implements  ImgStorageUtil{


    private static final Log log = LogFactory
            .getLog(ImgStorageTencentServiceImpl.class);

    private String APP_ID;
    private String SECRET_ID;
    private String SECRET_KEY;
    private String bucketName;
    private CosCloud cos;

    public ImgStorageTencentServiceImpl(String APP_ID,String SECRET_ID,String SECRET_KEY){
        super();
        this.APP_ID = APP_ID;
        this.SECRET_ID = SECRET_ID;
        this.SECRET_KEY = SECRET_KEY;
        if(null != APP_ID){
            cos = new CosCloud(Integer.valueOf(APP_ID), SECRET_ID, SECRET_KEY, 60);

        }
    }

    public void initClient(){
        log.info(" init start ");
        if(null != APP_ID){
            cos = new CosCloud(Integer.valueOf(APP_ID), SECRET_ID, SECRET_KEY, 60);

        }        log.info(" init cos success ");
    }
    public ImgStorageTencentServiceImpl() {
        super();
        if(null != APP_ID){
            cos = new CosCloud(Integer.valueOf(APP_ID), SECRET_ID, SECRET_KEY, 60);

        }        log.info(" init cos success ");
    }

    /**
     *
     * @param dir 只传module
     * @param yunFileName 传文件名称
     * @param picFile 本地路径
     * @return
     * @throws IOException
     */
    @Override
    public String imgStorage(String dir, String yunFileName, String picFile) throws IOException {

        log.info(" storage start  ");
        try {
            String  result = cos.getFolderList(bucketName, "/", 20, "", 0,
                    CosCloud.FolderPattern.Both);
            log.info("  getFolderList ");

            // 创造一个文件夹folder1
            result = cos.createFolder(bucketName, "/"+dir+"/");
            log.info("createFolder result: " + result);
            result = cos.uploadFile(bucketName, yunFileName, picFile);
            log.info(" result = "+result);
            System.out.println(" result = " + result);

            JSONObject jsonObject = new JSONObject(result);
            Integer code = (Integer)jsonObject.get("code");
            Integer success = 0;
            if(success.equals(code)){
                log.info(" upload file success ");
                JSONObject data = new JSONObject(jsonObject.get("data").toString()) ;
                String url =  data.get("access_url").toString();
                System.out.println(" url = " + url);
                return url;
            }else{
                log.info(" upload file failure ");

            }
            log.info("uploadFile result:" + result);
            return null;
        } catch (Exception e) {
            log.info(" upload file failure ");
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String imgStorage(String url, int timeOneHour) throws IOException {
        return null;
    }

    @Override
    public String imgGmkerl(String dir, String yunFileName, String picFile, Map<String, String> params) throws IOException {
        return null;
    }

    @Override
    public String imgRotate(String dir, String yunFileName, String picFile, String params) throws IOException {
        return null;
    }

    @Override
    public String imgCrop(String dir, String yunFileName, String picFile, String params) throws IOException {
        return null;
    }


    public String getAPP_ID() {
        return APP_ID;
    }

    public void setAPP_ID(String APP_ID) {
        this.APP_ID = APP_ID;
    }

    public String getSECRET_ID() {
        return SECRET_ID;
    }

    public void setSECRET_ID(String SECRET_ID) {
        this.SECRET_ID = SECRET_ID;
    }

    public String getSECRET_KEY() {
        return SECRET_KEY;
    }

    public void setSECRET_KEY(String SECRET_KEY) {
        this.SECRET_KEY = SECRET_KEY;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public CosCloud getCos() {
        return cos;
    }

    public void setCos(CosCloud cos) {
        this.cos = cos;
    }

    public static void main(String[] args) {
        log.info(" start  ");
        ImgStorageTencentServiceImpl tensent = new ImgStorageTencentServiceImpl("10047330","AKIDORGABt7yubFPO4NVyw3yF2fwPmD6GiJH","xtacEMxQTGTBMsavFoTJ57NL20llisTs");
        tensent.setBucketName("learn");

        tensent.initClient();
        try {
            tensent.imgStorage("article","test3.png","C:\\Users\\liangxj\\Desktop\\hahahha.png");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
