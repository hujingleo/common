package com.gemantic.commons.code.manager;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gemantic.commons.code.manager.android.AndroidCodeGenerate;
import com.gemantic.commons.code.manager.android.impl.AndroidProjectImpl;
import com.gemantic.commons.code.manager.ios.IOSCodeGenerate;
import com.gemantic.commons.code.model.android.AndroidProject;
import com.gemantic.commons.code.model.ios.IOSProject;
import com.google.gson.Gson;
import com.qding.common.util.FileUtil;

@Ignore
public class CodeGenerateIOSTest {
	
	private static final Log log = LogFactory.getLog(CodeGenerateIOSTest.class);
	
	
	
	
	
	@Test
	public void testIOSGenerate() throws IOException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/commons-code-mananger/applicationContext.xml");
		IOSCodeGenerate generate = (IOSCodeGenerate) context.getBean("iOSCodeGenerate");
		
		IOSProject project=MockUtil.mockIOSProject();
		
		Gson gson=new Gson();
		FileUtil.writeFile("D:\\data\\code\\ios\\data.json", false, gson.toJson(project));
	
		
		generate.generateControllerMFile(project);
		generate.generateControllerHFile(project);
		
		generate.generateViewMFile(project);
		generate.generateViewHFile(project);
		
		generate.generateModelMFile(project);
		generate.generateModelHFile(project);
		
		
		
		generate.generateServiceHFile(project);
		generate.generateServiceMFile(project);
		generate.generateInterfaceConfigFile(project);
	
		
		
		
	/*	
				String json=FileUtil.readFileAsString("D:\\data\\code\\ios\\data.json");
				IOSProject project2=GsonUtil.fromJson(json, IOSProject.class);
				log.info(project2);
				
				
				generate.generateControllerMFile(project2);
				generate.generateControllerHFile(project2);*/
		
	}
	
	@Test
	public void testAndroid(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/commons-code-mananger/applicationContext.xml");
		IOSCodeGenerate generate = (IOSCodeGenerate) context.getBean("iOSCodeGenerate");
		
		IOSProject project=MockUtil.mockIOSProject();
		
		Gson gson=new Gson();
		FileUtil.writeFile("D:\\data\\code\\ios\\data.json", false, gson.toJson(project));
	

		
		AndroidProject androidProject=MockUtil.mockAndroidProject(project);
		AndroidCodeGenerate androidGenerate = (AndroidCodeGenerate) context.getBean("androidCodeGenerate");
		
		
	
		androidGenerate.generateModelFile(androidProject);		
		androidGenerate.generatePresenterFile(androidProject);
		androidGenerate.generateServiceFile(androidProject);
	}

}
