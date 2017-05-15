package com.ptteng.haichuan.audit.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Late;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface LateService extends BaseDaoService {

	



   		   
		
		public Long insert(Late late)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Late> insertList(List<Late> lateList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Late late)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Late> lateList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Late getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Late> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getLateIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countLateIds() throws ServiceException, ServiceDaoException;
	

}

