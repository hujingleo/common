/**
 * 
 */
package com.ptteng.sca.haichuan.audit.client;

import java.util.List;
import java.util.Map;

import com.ptteng.haichuan.audit.model.Team;
import com.ptteng.haichuan.audit.service.TeamService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class TeamSCAClient implements TeamService {

    private TeamService teamService;

	public TeamService getTeamService() {
		return teamService;
	}
	
	
	public void setTeamService(TeamService teamService) {
		this.teamService =teamService;
	}
	
	
			   
		@Override
		public Long insert(Team team)throws ServiceException, ServiceDaoException{
		
		return teamService.insert(team);
		          
		
		}	
		  
    	   
		@Override
		public List<Team> insertList(List<Team> teamList)throws ServiceException, ServiceDaoException{
		
		return teamService.insertList(teamList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return teamService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Team team)throws ServiceException, ServiceDaoException{
		
		return teamService.update(team);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Team> teamList)throws ServiceException, ServiceDaoException{
		
		return teamService.updateList(teamList);
		          
		
		}	
		  
    	   
		@Override
		public Team getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return teamService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Team> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return teamService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getTeamIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return teamService.getTeamIds(start, limit);
	}

	@Override
	public Integer countTeamIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return teamService.countTeamIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return teamService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return teamService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   teamService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.teamService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

