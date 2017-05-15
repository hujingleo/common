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

import com.ptteng.haichuan.audit.model.Leave;
import com.ptteng.haichuan.audit.service.LeaveService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class LeaveServiceTest {

	private static final Log log = LogFactory.getLog(LeaveServiceTest.class);
	
	private LeaveService leaveService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/haichuan-audit-service/applicationContext-server.xml");
	        leaveService = (LeaveService) context.getBean("leaveService");
			//local server
			/**
			leaveService = (LeaveService)  Naming.lookup("//localhost:10733/LeaveRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 leaveService = (LeaveService) context.getBean("leaveService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Leave leave  = new Leave();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	 
	 
	  Long id= this.leaveService.insert(leave);

      leave = this.leaveService.getObjectById(id);

	  Leave leave2=this.leaveService.getObjectById(id);
	    Assert.assertNotNull(leave2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				boolean success=this.leaveService.update(leave);		
		Assert.assertEquals(true, success);
		 Leave leave3=this.leaveService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.leaveService.delete(id);	
		Assert.assertEquals(true, success);
		Leave leave4=this.leaveService.getObjectById(id);
		Assert.assertNull(leave4);
		
		//4.batchInsert
		 List<Leave> list=new ArrayList<Leave>();
	  	  Leave leave5  = new Leave();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	    list.add(leave5);	   
	  	  Leave leave6  = new Leave();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	   list.add(leave6);
	   List<Leave> insertResults= this.leaveService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Leave o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Leave> getResults= this.leaveService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Leave o :insertResults){
			this.leaveService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

