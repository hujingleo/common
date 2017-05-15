package com.gemantic.commons.code.util;

import java.io.*;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;



@Component("velocityGenerateFileUtil")
public class GenerateFileUtil {

	private static final Log log = LogFactory.getLog(GenerateFileUtil.class);

	@Autowired
	private VelocityEngine velocityEngine;
	
	

	/**
	 * 
	 * @param model
	 * @param template
	 * @param path
	 * @param fileName
	 * @param isAppend true 追加 |false new 
	 * @return
	 */
	public  String generateFile(Map model, String template,String path, String fileName,Boolean isAppend) {

		String content = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, template, model);
		writeFile(path, fileName, isAppend, content);

		log.info(path + fileName + " created ==============succeess ");

		return fileName;

	}
	public  String generateFileEncoding(Map model, String template,String path, String fileName,Boolean isAppend,String encoding) {

		String content = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, template, model);
		writeFileEncoding(path, fileName, isAppend, content, encoding);

		log.info(path + fileName + " created ==============succeess ");

		return fileName;

	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public static void writeFile(String path, String name, boolean append, String content) {
		File myFilePath = new File(path + name);

		try {
			boolean e = (new File(path)).mkdirs();
			if(e) {
				System.out.println("Directories: " + path + " created");
			}

			if(!myFilePath.exists()) {
				myFilePath.createNewFile();
			}

			FileWriter resultFile = new FileWriter(myFilePath, append);
			PrintWriter myFile = new PrintWriter(resultFile);
			myFile.println(content);
			resultFile.close();
		} catch (Exception var8) {
			System.out.println("新建文件操作出错");
			var8.printStackTrace();
		}

	}
	public static void writeFileEncoding(String path, String name, boolean append, String content,String encoding) {
		File myFilePath = new File(path + name);

		try {
			boolean e = (new File(path)).mkdirs();
			if(e) {
				System.out.println("Directories: " + path + " created");
			}

			if(!myFilePath.exists()) {
				myFilePath.createNewFile();
			}

//			FileWriter resultFile = new FileWriter(myFilePath, append);
//			PrintWriter myFile = new PrintWriter(resultFile);
//			myFile.println(content);
//			resultFile.close();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(myFilePath), encoding));
			writer.write(content);
			writer.close();


		} catch (Exception var8) {
			System.out.println("新建文件操作出错");
			var8.printStackTrace();
		}

	}

}
