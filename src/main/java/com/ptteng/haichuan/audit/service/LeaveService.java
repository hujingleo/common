package com.ptteng.haichuan.audit.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Leave;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface LeaveService extends BaseDaoService {

	



   		   
		
		public Long insert(Leave leave)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Leave> insertList(List<Leave> leaveList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Leave leave)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Leave> leaveList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Leave getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Leave> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getLeaveIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countLeaveIds() throws ServiceException, ServiceDaoException;
	

}

