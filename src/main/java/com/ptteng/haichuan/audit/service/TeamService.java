package com.ptteng.haichuan.audit.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Team;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface TeamService extends BaseDaoService {

	



   		   
		
		public Long insert(Team team)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Team> insertList(List<Team> teamList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Team team)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Team> teamList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Team getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Team> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getTeamIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countTeamIds() throws ServiceException, ServiceDaoException;
	

}

