/**
 * 
 */
package com.ptteng.sca.haichuan.audit.client;

import java.util.List;
import java.util.Map;

import com.ptteng.haichuan.audit.model.Leave;
import com.ptteng.haichuan.audit.service.LeaveService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class LeaveSCAClient implements LeaveService {

    private LeaveService leaveService;

	public LeaveService getLeaveService() {
		return leaveService;
	}
	
	
	public void setLeaveService(LeaveService leaveService) {
		this.leaveService =leaveService;
	}
	
	
			   
		@Override
		public Long insert(Leave leave)throws ServiceException, ServiceDaoException{
		
		return leaveService.insert(leave);
		          
		
		}	
		  
    	   
		@Override
		public List<Leave> insertList(List<Leave> leaveList)throws ServiceException, ServiceDaoException{
		
		return leaveService.insertList(leaveList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return leaveService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Leave leave)throws ServiceException, ServiceDaoException{
		
		return leaveService.update(leave);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Leave> leaveList)throws ServiceException, ServiceDaoException{
		
		return leaveService.updateList(leaveList);
		          
		
		}	
		  
    	   
		@Override
		public Leave getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return leaveService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Leave> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return leaveService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getLeaveIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return leaveService.getLeaveIds(start, limit);
	}

	@Override
	public Integer countLeaveIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return leaveService.countLeaveIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return leaveService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return leaveService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   leaveService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.leaveService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

