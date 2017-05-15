package com.ptteng.haichuan.audit.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Storage;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface StorageService extends BaseDaoService {

	



   		   
		
		public Long insert(Storage storage)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Storage> insertList(List<Storage> storageList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Storage storage)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Storage> storageList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Storage getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Storage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getStorageIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countStorageIds() throws ServiceException, ServiceDaoException;
	

}

