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

import com.ptteng.haichuan.audit.model.Storage;
import com.ptteng.haichuan.audit.service.StorageService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class StorageServiceTest {

	private static final Log log = LogFactory.getLog(StorageServiceTest.class);
	
	private StorageService storageService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/haichuan-audit-service/applicationContext-server.xml");
	        storageService = (StorageService) context.getBean("storageService");
			//local server
			/**
			storageService = (StorageService)  Naming.lookup("//localhost:10733/StorageRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 storageService = (StorageService) context.getBean("storageService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Storage storage  = new Storage();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	 
	 
	  Long id= this.storageService.insert(storage);

      storage = this.storageService.getObjectById(id);

	  Storage storage2=this.storageService.getObjectById(id);
	    Assert.assertNotNull(storage2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				boolean success=this.storageService.update(storage);		
		Assert.assertEquals(true, success);
		 Storage storage3=this.storageService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.storageService.delete(id);	
		Assert.assertEquals(true, success);
		Storage storage4=this.storageService.getObjectById(id);
		Assert.assertNull(storage4);
		
		//4.batchInsert
		 List<Storage> list=new ArrayList<Storage>();
	  	  Storage storage5  = new Storage();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	    list.add(storage5);	   
	  	  Storage storage6  = new Storage();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	   list.add(storage6);
	   List<Storage> insertResults= this.storageService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Storage o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Storage> getResults= this.storageService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Storage o :insertResults){
			this.storageService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

