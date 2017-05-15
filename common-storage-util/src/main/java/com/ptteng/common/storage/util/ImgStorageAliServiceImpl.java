package com.ptteng.common.storage.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.Map;
import org.apache.http.ssl.TrustStrategy;



/**
 * Created by liangxj on 2016/8/2.
 */
public class ImgStorageAliServiceImpl implements ImgStorageUtil {
    private static final Log log = LogFactory
            .getLog(ImgStorageTencentServiceImpl.class);

    //http://zhhd.oss-cn-beijing.aliyuncs.com/dd.png
    private String endpoint ;
    // accessKey请登录https://ak-console.aliyun.com/#/查看
    private String accessKeyId ;
    private String accessKeySecret;
    private String bucketName;
    private OSSClient ossClient ;


    public ImgStorageAliServiceImpl(String endpoint,String accessKeyId,String accessKeySecret,String bucketName,String url) {
        super();
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName  = bucketName;
        ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);

        log.info(" init cos success ");
    }

    public ImgStorageAliServiceImpl() {
        super();

      //  ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);

        log.info(" init cos success ");
    }
    public void initClient(){
        log.info(" init start ");

        ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);

               log.info(" init cos success ");
    }

    @Override
    public String imgStorage(String dir, String yunFileName, String picFile) throws IOException {

        log.info(" bucketName = "+bucketName);
        // 上传文件
        PutObjectResult putObjectResult =  ossClient.putObject(new PutObjectRequest(bucketName,yunFileName,new File(picFile)));
        log.info("  putObjectResult eTag =  " + putObjectResult.getETag());
       // System.out.println("  putObjectResult = "+putObjectResult);
        System.out.println("  eTag = " + putObjectResult.getETag());
       // System.out.println("  callbackResponseBody = "+putObjectResult.getCallbackResponseBody());


//        OSSObject object = ossClient.getObject(new GetObjectRequest(bucketName, yunFileName));
//         System.out.println("Content-Type: " + object.getObjectMetadata().getContentType());
//        displayTextInputStream(object.getObjectContent());

        String fileUrl = "http://"+bucketName+"."+endpoint+"/"+yunFileName;
        log.info(" fileUrl = "+fileUrl);
        return fileUrl;
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

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public OSSClient getOssClient() {
        return ossClient;
    }

    public void setOssClient(OSSClient ossClient) {
        this.ossClient = ossClient;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
    private static void displayTextInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,"utf-8"));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            System.out.println("\t" + line);
        }
        System.out.println();

        reader.close();
    }

    public static void main(String[] args) {
        log.info(" start  ");
        ImgStorageAliServiceImpl tensent = new ImgStorageAliServiceImpl();
        tensent.setEndpoint("oss-cn-shanghai.aliyuncs.com");
        tensent.setAccessKeyId("LTAIEPMkD80uYm0p");
        tensent.setAccessKeySecret("vMFgog16wRsTnmbFtwBnbgJ8hcRfi6");
        tensent.setBucketName("jinxin-uk");
//        tensent.setEndpoint("zhhdoss.5818cp.cn");
//        tensent.setAccessKeyId("xCvqFmfvaySHQP1P");
//        tensent.setAccessKeySecret("1o1w4iy1FgJMJQQMmiVeyGdDzokY0m");
//        tensent.setBucketName("zhhd");
        tensent.initClient();
        try {
            String url = tensent.imgStorage("article","test5.png","C:\\Users\\liangxj\\Desktop\\hahahha.png");
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
