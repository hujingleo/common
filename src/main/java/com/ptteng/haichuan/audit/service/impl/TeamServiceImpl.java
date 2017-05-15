package com.ptteng.haichuan.audit.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.haichuan.audit.model.Team;
import com.ptteng.haichuan.audit.service.TeamService;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;


public class TeamServiceImpl extends BaseDaoServiceImpl implements TeamService {

 

	private static final Log log = LogFactory.getLog(TeamServiceImpl.class);



		   
		@Override
		public Long insert(Team team)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + team);

		if (team == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		team.setCreateAt(currentTimeMillis);
		team.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(team);
		} catch (DaoException e) {
			log.error(" insert wrong : " + team);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Team> insertList(List<Team> teamList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (teamList == null ? "null" : teamList.size()));
      
		List<Team> resultList = null;

		if (CollectionUtils.isEmpty(teamList)) {
			return new ArrayList<Team>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Team team : teamList) {
			team.setCreateAt(currentTimeMillis);
			team.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Team>) dao.batchSave(teamList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + teamList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Team.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(Team team)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (team == null ? "null" : team.getId()));

		boolean result = false;

		if (team == null) {
			return true;
		}

		team.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(team);
		} catch (DaoException e) {
			log.error(" update wrong : " + team);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + team);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Team> teamList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (teamList == null ? "null" : teamList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(teamList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Team team : teamList) {
			team.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(teamList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + teamList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + teamList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Team getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Team team = null;

		if (id == null) {
			return team;
		}

		try {
			team = (Team) dao.get(Team.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return team;		
		}	
		  
    	   
		@Override
		public List<Team> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Team> team = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Team>();
		}

		try {
			team = (List<Team>) dao.getList(Team.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (team == null ? "null" : team.size()));
    
		return team;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getTeamIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getTeamIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countTeamIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getTeamIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getTeamIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

