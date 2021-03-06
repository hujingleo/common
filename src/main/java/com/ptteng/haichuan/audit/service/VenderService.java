package com.ptteng.haichuan.audit.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Vender;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface VenderService extends BaseDaoService {

	



   		   
		
		public Long insert(Vender vender)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Vender> insertList(List<Vender> venderList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Vender vender)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Vender> venderList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Vender getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Vender> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getVenderIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countVenderIds() throws ServiceException, ServiceDaoException;
	

}

