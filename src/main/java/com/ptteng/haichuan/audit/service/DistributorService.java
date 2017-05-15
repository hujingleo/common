package com.ptteng.haichuan.audit.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Distributor;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface DistributorService extends BaseDaoService {

	



   		   
		
		public Long insert(Distributor distributor)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Distributor> insertList(List<Distributor> distributorList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Distributor distributor)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Distributor> distributorList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Distributor getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Distributor> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getDistributorIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countDistributorIds() throws ServiceException, ServiceDaoException;
	

}

