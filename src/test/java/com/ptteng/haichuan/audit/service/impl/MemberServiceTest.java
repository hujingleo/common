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

import com.ptteng.haichuan.audit.model.Member;
import com.ptteng.haichuan.audit.service.MemberService;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
@Ignore
public class MemberServiceTest {

	private static final Log log = LogFactory.getLog(MemberServiceTest.class);
	
	private MemberService memberService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/haichuan-audit-service/applicationContext-server.xml");
	        memberService = (MemberService) context.getBean("memberService");
			//local server
			/**
			memberService = (MemberService)  Naming.lookup("//localhost:10733/MemberRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 memberService = (MemberService) context.getBean("memberService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Member member  = new Member();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	 
	 
	  Long id= this.memberService.insert(member);

      member = this.memberService.getObjectById(id);

	  Member member2=this.memberService.getObjectById(id);
	    Assert.assertNotNull(member2);
	  
		// 2. 更改 
				 		 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 					 				 		 				 		 				boolean success=this.memberService.update(member);		
		Assert.assertEquals(true, success);
		 Member member3=this.memberService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				//3.删除
		boolean successDelete=this.memberService.delete(id);	
		Assert.assertEquals(true, success);
		Member member4=this.memberService.getObjectById(id);
		Assert.assertNull(member4);
		
		//4.batchInsert
		 List<Member> list=new ArrayList<Member>();
	  	  Member member5  = new Member();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	    list.add(member5);	   
	  	  Member member6  = new Member();	   
	   					 
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					
			   					 
			   					 
			   	   list.add(member6);
	   List<Member> insertResults= this.memberService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Member o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Member> getResults= this.memberService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Member o :insertResults){
			this.memberService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

