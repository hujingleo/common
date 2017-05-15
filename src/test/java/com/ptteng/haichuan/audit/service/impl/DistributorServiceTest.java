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

import com.ptteng.haichuan.audit.model.Distributor;
import com.ptteng.haichuan.audit.service.DistributorService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class DistributorServiceTest {

	private static final Log log = LogFactory.getLog(DistributorServiceTest.class);
	
	private DistributorService distributorService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/haichuan-audit-service/applicationContext-server.xml");
	        distributorService = (DistributorService) context.getBean("distributorService");
			//local server
			/**
			distributorService = (DistributorService)  Naming.lookup("//localhost:10733/DistributorRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 distributorService = (DistributorService) context.getBean("distributorService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Distributor distributor  = new Distributor();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	 
	 
	  Long id= this.distributorService.insert(distributor);

      distributor = this.distributorService.getObjectById(id);

	  Distributor distributor2=this.distributorService.getObjectById(id);
	    Assert.assertNotNull(distributor2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				boolean success=this.distributorService.update(distributor);		
		Assert.assertEquals(true, success);
		 Distributor distributor3=this.distributorService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.distributorService.delete(id);	
		Assert.assertEquals(true, success);
		Distributor distributor4=this.distributorService.getObjectById(id);
		Assert.assertNull(distributor4);
		
		//4.batchInsert
		 List<Distributor> list=new ArrayList<Distributor>();
	  	  Distributor distributor5  = new Distributor();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	    list.add(distributor5);	   
	  	  Distributor distributor6  = new Distributor();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	   list.add(distributor6);
	   List<Distributor> insertResults= this.distributorService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Distributor o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Distributor> getResults= this.distributorService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Distributor o :insertResults){
			this.distributorService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

