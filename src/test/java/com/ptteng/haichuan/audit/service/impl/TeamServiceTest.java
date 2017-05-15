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

import com.ptteng.haichuan.audit.model.Team;
import com.ptteng.haichuan.audit.service.TeamService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class TeamServiceTest {

	private static final Log log = LogFactory.getLog(TeamServiceTest.class);
	
	private TeamService teamService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/haichuan-audit-service/applicationContext-server.xml");
	        teamService = (TeamService) context.getBean("teamService");
			//local server
			/**
			teamService = (TeamService)  Naming.lookup("//localhost:10733/TeamRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 teamService = (TeamService) context.getBean("teamService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Team team  = new Team();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	 
	 
	  Long id= this.teamService.insert(team);

      team = this.teamService.getObjectById(id);

	  Team team2=this.teamService.getObjectById(id);
	    Assert.assertNotNull(team2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				boolean success=this.teamService.update(team);		
		Assert.assertEquals(true, success);
		 Team team3=this.teamService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.teamService.delete(id);	
		Assert.assertEquals(true, success);
		Team team4=this.teamService.getObjectById(id);
		Assert.assertNull(team4);
		
		//4.batchInsert
		 List<Team> list=new ArrayList<Team>();
	  	  Team team5  = new Team();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	    list.add(team5);	   
	  	  Team team6  = new Team();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	   list.add(team6);
	   List<Team> insertResults= this.teamService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Team o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Team> getResults= this.teamService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Team o :insertResults){
			this.teamService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

