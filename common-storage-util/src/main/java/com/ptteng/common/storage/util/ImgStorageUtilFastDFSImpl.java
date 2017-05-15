package com.ptteng.common.storage.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImgStorageUtilFastDFSImpl implements ImgStorageUtil {
	private static final Log log = LogFactory.getLog(ImgStorageUtilFastDFSImpl.class);
	@Override
	public String imgStorage(String dir, String yunFileName, String picFile)
			throws IOException {
            
        try {
            
            File tempPic = new File(picFile);
            
            log.info(" UPLOAD FILE PATH : "+tempPic.getAbsolutePath());
            String url = FastdfsUtil.upload(tempPic.getAbsolutePath());
            log.info("URL : "+url);
           return url;
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(picFile+" error ");
        }
		return null;

       
    }

	@Override
	public String imgStorage(String url, int timeOneHour) throws IOException {
		return null;
	}

	@Override
	public String imgGmkerl(String dir, String yunFileName, String picFile,
			Map<String, String> params) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String imgRotate(String dir, String yunFileName, String picFile,
			String params) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String imgCrop(String dir, String yunFileName, String picFile,
			String params) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
