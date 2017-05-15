package com.ptteng.haichuan.audit.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import java.rmi.Naming;

import com.ptteng.haichuan.audit.model.Late;
import com.ptteng.haichuan.audit.service.LateService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class LateServiceTest {

	private static final Log log = LogFactory.getLog(LateServiceTest.class);
	
	private LateService lateService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/haichuan-audit-service/applicationContext-server.xml");
	        lateService = (LateService) context.getBean("lateService");
			//local server
			/**
			lateService = (LateService)  Naming.lookup("//localhost:10733/LateRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 lateService = (LateService) context.getBean("lateService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Late late  = new Late();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	 
	 
	  Long id= this.lateService.insert(late);

      late = this.lateService.getObjectById(id);

	  Late late2=this.lateService.getObjectById(id);
	    Assert.assertNotNull(late2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				boolean success=this.lateService.update(late);		
		Assert.assertEquals(true, success);
		 Late late3=this.lateService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.lateService.delete(id);	
		Assert.assertEquals(true, success);
		Late late4=this.lateService.getObjectById(id);
		Assert.assertNull(late4);
		
		//4.batchInsert
		 List<Late> list=new ArrayList<Late>();
	  	  Late late5  = new Late();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	    list.add(late5);	   
	  	  Late late6  = new Late();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	   list.add(late6);
	   List<Late> insertResults= this.lateService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Late o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Late> getResults= this.lateService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Late o :insertResults){
			this.lateService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

