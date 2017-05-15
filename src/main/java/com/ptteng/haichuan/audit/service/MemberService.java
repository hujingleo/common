package com.ptteng.haichuan.audit.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Member;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface MemberService extends BaseDaoService {

	



   		   
		
		public Long insert(Member member)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Member> insertList(List<Member> memberList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Member member)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Member> memberList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Member getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Member> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getMemberIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countMemberIds() throws ServiceException, ServiceDaoException;
	

}

