package com.ptteng.common.storage.util;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastdfsUtil {

    private static final Log  log = LogFactory.getLog(FastdfsUtil.class) ;
    public static final String DEFAULT_FDFS_CLIENT_CONF_FILE = "fdfs_client.conf";
    /**
     * 在fdfs_client.conf 中增加下面的配置，指定group name, 中间用 空格 间隔
     * group_name group208
     */
    private static String GROUP_NAME = null;

    static {
        URL configFile = Thread.currentThread().getContextClassLoader().getResource(DEFAULT_FDFS_CLIENT_CONF_FILE);

        try {
            ClientGlobal.init(configFile.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Properties properties = new Properties();
            properties.load(configFile.openStream());
            Object obj = properties.get("group_name");
            if (null != obj) {
                GROUP_NAME = (String)obj;
                GROUP_NAME = GROUP_NAME.trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 将local_file上传到fastdfs上 </br>
     * 如果指定group name, 需要在fdfs_client.conf 中增加下面的配置，指定group name, 中间用 空格 间隔
     *
     * @param local_filename
     * @return 下载相对路径（group name + file name）
     * @throws Exception
     */
    public static final String upload(String local_filename) throws Exception {
        log.info("start upload file : " + local_filename) ;
        long start = System.currentTimeMillis() ;
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);

        NameValuePair[] metaList = new NameValuePair[1];
        metaList[0] = new NameValuePair("fileName", local_filename);
        String fileId = null;
        if (StringUtils.isBlank(GROUP_NAME)) {
            fileId = client.upload_file1(local_filename, null, metaList);
        } else {
            fileId = client.upload_file1(GROUP_NAME, local_filename, null, metaList);
        }
        trackerServer.close();
        log.info("success upload file : groupName = " + GROUP_NAME + "; localname = " + local_filename + "; fileId = " + fileId + ", time : " + (System.currentTimeMillis()-start) + "ms") ;
        return fileId;
    }

    /**
     * 将local_file上传到fastdfs上
     *
     * @param local_filename
     * @return 下载相对路径
     * @throws Exception
     */
    public static final String uploadFileBytes(byte[] fileBytes, String local_filename, String ext_name) throws Exception {
        log.info("start upload file : " + local_filename) ;
        long start = System.currentTimeMillis() ;
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);

        NameValuePair[] metaList = new NameValuePair[1];
        metaList[0] = new NameValuePair("fileName", local_filename);
        String fileId = client.upload_file1(fileBytes, ext_name, metaList);
        trackerServer.close();
        log.info("success upload file : localname = " + local_filename + "; fileId = " + fileId + ", time : " + (System.currentTimeMillis()-start) + "ms") ;
        return fileId;
    }


    /**
     * 根据file_id 删掉
     *
     * @param file_id the file id(including group name and filename)
     * @return 0 for success, none zero for fail (error code)
     * @throws Exception
     */
    public static final int delete(String file_id) throws Exception {

        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);
        return client.delete_file1(file_id) ;

    }

}
