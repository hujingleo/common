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

import com.ptteng.haichuan.audit.model.Vender;
import com.ptteng.haichuan.audit.service.VenderService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class VenderServiceTest {

	private static final Log log = LogFactory.getLog(VenderServiceTest.class);
	
	private VenderService venderService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/haichuan-audit-service/applicationContext-server.xml");
	        venderService = (VenderService) context.getBean("venderService");
			//local server
			/**
			venderService = (VenderService)  Naming.lookup("//localhost:10733/VenderRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 venderService = (VenderService) context.getBean("venderService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Vender vender  = new Vender();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	 
	 
	  Long id= this.venderService.insert(vender);

      vender = this.venderService.getObjectById(id);

	  Vender vender2=this.venderService.getObjectById(id);
	    Assert.assertNotNull(vender2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				boolean success=this.venderService.update(vender);		
		Assert.assertEquals(true, success);
		 Vender vender3=this.venderService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.venderService.delete(id);	
		Assert.assertEquals(true, success);
		Vender vender4=this.venderService.getObjectById(id);
		Assert.assertNull(vender4);
		
		//4.batchInsert
		 List<Vender> list=new ArrayList<Vender>();
	  	  Vender vender5  = new Vender();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	    list.add(vender5);	   
	  	  Vender vender6  = new Vender();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	   list.add(vender6);
	   List<Vender> insertResults= this.venderService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Vender o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Vender> getResults= this.venderService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Vender o :insertResults){
			this.venderService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

